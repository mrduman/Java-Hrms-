package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
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
	private VerificationCodeCandidateService verificationCodeCandidateService;
	

	@Autowired
	public CandidateManager(CandidateDao candidateDao , UserService userService,VerificationCodeCandidateService verificationCodeCandidateService) {
		super();
		this.candidateDao = candidateDao;
		this.userService = userService;
		this.verificationCodeCandidateService = verificationCodeCandidateService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Job Seekers had listed");
	}

	@Override
	public Result add(RegisterForCandidateDTO candidate) {
		
		if( candidate.getFirstName().isEmpty()
			|| candidate.getLastName().isEmpty()
			|| candidate.getPassword().isEmpty()
			|| candidate.getIdentityNumber().isEmpty()
			|| candidate.getEMail().isEmpty()
			|| candidate.getBirthOfYear().isEmpty()
			|| candidate.getConfirmPassword().isEmpty()) 
		{
			
			return new ErrorResult("No fields can be lef blank");
		} 
		else if (!identityNumberControl(candidate.getIdentityNumber()).isSuccess()) {
			
			return new ErrorResult("This nationality id had already in the System");
		}
		else if (!userService.emailControl(candidate.getEMail()).isSuccess()) {
			
			return new ErrorResult("This E-mail had already in the System");
			
		} 
        else if(candidate.getConfirmPassword() != candidate.getPassword()){
			
			return new ErrorResult("Confirm Password must to be same with Password");
			
		}else {
			
	Candidate newCandidate = new Candidate(candidate.getFirstName(),candidate.getLastName(),candidate.getIdentityNumber(),
				candidate.getBirthOfYear(),candidate.getConfirmPassword(), candidate.getEMail());
					 
						
				this.candidateDao.save(newCandidate);
				
				return new SuccessResult("Candidate had accepted"); 
				
	}
		
	}
	

	@Override
	public Result identityNumberControl(String identityNumber) {
		
		List<Candidate> candidates = this.candidateDao.findByIdentityNumber(identityNumber);
		
		if(!(candidates.isEmpty())) {
			
			return new ErrorResult("There is a already same Idendity Number");
			
		}
		
		return new SuccessResult();
		
	}

	@Override
	public Result isEmailVerified(String email) {
		
		verificationCodeCandidateService.emailVerificationCode(email);
		
		return new SuccessResult("E-mail Code had confirmed");
	}

	
	
}
