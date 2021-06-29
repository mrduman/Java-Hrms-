package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeCandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.DTOs.RegisterForEmployerDTO;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	
	private EmployerDao employerDao;
	private UserService userService;
	private VerificationCodeCandidateService verificationCodeCandidateService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService,VerificationCodeCandidateService verificationCodeCandidateService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;
		this.verificationCodeCandidateService = verificationCodeCandidateService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer listed");
		
		
	}

	@Override
	public Result add(RegisterForEmployerDTO employer) {
		
		if(!(employer.getEMail().split("@") == employer.getWebAddress().split("www."))) {
			
			return new ErrorResult("Domains have to be same");
		}
		else if (employer.getCompanyName().isEmpty()
				|| employer.getEMail().isEmpty()
				|| employer.getPassword().isEmpty()
				|| employer.getPhoneNumber().isEmpty()
				|| employer.getWebAddress().isEmpty()
				|| employer.getConfirmPassword().isEmpty()) {
			
			return new ErrorResult("No Fields can be lef blank");
		} 
		else if (!userService.emailControl(employer.getEMail()).isSuccess()) {
			
			return new ErrorResult("There is a same E-mail in Database");
			
		} else if(employer.getConfirmPassword() != employer.getPassword()){
			
			return new ErrorResult("Confirm Password must to be same with Password");
		}

	Employer newEmployer = new Employer(employer.getCompanyName(), employer.getWebAddress(), employer.getPhoneNumber(),
			employer.getPassword(), employer.getEMail());
		
	this.employerDao.save(newEmployer);
	
	return new SuccessResult("Employer has added");
	
	}

	@Override
	public Result isEmailVerified(String email) {
		
		verificationCodeCandidateService.emailVerificationCode(email);
		
		return new SuccessResult("E-Mail code had verified");
	}

}
