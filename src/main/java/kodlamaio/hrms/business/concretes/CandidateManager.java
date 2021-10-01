package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.core.utilities.helpers.BusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;

import kodlamaio.hrms.entities.DTOs.RegisterForCandidateDTO;
import kodlamaio.hrms.entities.concretes.Candidate;


@Service
public class CandidateManager implements CandidateService{

	private CandidateDao candidateDao;
	private UserService userService;

	

	@Autowired
	public CandidateManager(CandidateDao candidateDao , UserService userService) {
		super();
		this.candidateDao = candidateDao;
		this.userService = userService;

	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Job Seekers had listed");
	}

	@Override
	public Result add(RegisterForCandidateDTO candidate) {

		Result result = BusinessRule.run(checkPasswordsMatch(candidate),identityNumberControl(candidate.getIdentityNumber()),
				emailControl(candidate)); // Burada neden candidate.getIdentityNumber() yazdık.!!!

		if(!result.isSuccess()){
			return result;
		}


	/*	if( candidate.getFirstName().isEmpty()
			|| candidate.getLastName().isEmpty()
			|| candidate.getPassword().isEmpty()
			|| candidate.getIdentityNumber().isEmpty()
			|| candidate.getEmail().isEmpty()
			|| candidate.getBirthOfYear().isEmpty()
			|| candidate.getConfirmPassword().isEmpty()) 
		{
			
			return new ErrorResult("No fields can be left blank");
		}


         else { */

	Candidate newCandidate = new Candidate(candidate.getBirthOfYear(),candidate.getFirstName(),candidate.getIdentityNumber(),candidate.getLastName(), candidate.getEmail(),candidate.getConfirmPassword());

				this.candidateDao.save(newCandidate);

				return new SuccessResult("Candidate had accepted");
	}
		
	//}

	@Override
	public Result identityNumberControl(String identityNumber) {
		
		List<Candidate> candidates = this.candidateDao.findByIdentityNumber(identityNumber);
		
		if(!(candidates.isEmpty())) {
			
			return new ErrorResult("There is a already same Idendity Number");
			
		}
		
		return new SuccessResult();
		
	}

	@Override
	public Result isEmailVerified(int id) {

	Candidate candidate = this.candidateDao.getById(id);

	if(candidate == null) {

		return new ErrorResult("Candidate has not found");
	}

	candidate.setEmailVerified(true);
	candidateDao.save(candidate);

		return new SuccessResult("Email verified");
	}

	
	private Result checkPasswordsMatch(RegisterForCandidateDTO candidate){
		if(!candidate.getPassword().equals(candidate.getConfirmPassword())){

			return new ErrorResult("Confirm Password must to be same with Password");

		}
		return new SuccessResult();
	}

	    private Result emailControl(RegisterForCandidateDTO candidate) {

			 if (!userService.emailControl(candidate.getEmail()).isSuccess()) {


				 return new ErrorResult("This E-mail had already in the System");
		}
		return new SuccessResult();
	}
}


