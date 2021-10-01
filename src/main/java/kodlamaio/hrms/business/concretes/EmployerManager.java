package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.core.utilities.helpers.BusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
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

	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService) {
		super();
		this.employerDao = employerDao;
		this.userService = userService;

	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employer listed");
		
	}

	@Override
	public Result add(RegisterForEmployerDTO employer) {

		Result result = BusinessRule.run(emailControl(employer));

		if(!result.isSuccess()){

			return result;
		}

		if(!(employer.getEmail().split("@")[1].equals(employer.getWebAddress().split("www.")[1]))) {
			
			return new ErrorResult("Domains have to be same");
		}
	/*	else if (employer.getCompanyName().isEmpty()
				|| employer.getEmail().isEmpty()
				|| employer.getPassword().isEmpty()
				|| employer.getPhoneNumber().isEmpty()
				|| employer.getWebAddress().isEmpty()
				|| employer.getConfirmPassword().isEmpty()) {
			
			return new ErrorResult("No Fields can be lef blank");
		} */


	Employer newEmployer = new Employer( employer.getEmail(),employer.getPassword(),employer.getCompanyName(), employer.getWebAddress(), employer.getPhoneNumber()			);
		
	this.employerDao.save(newEmployer);
	
	return new SuccessResult("Employer has added");
	
	}

	@Override
	public Result isEmailVerified(int id) {

		Employer employer = this.employerDao.getById(id);

		if(employer == null) {
			return new ErrorResult("Employer has not found");
		}
		employer.setEmailVerified(true);
		employerDao.save(employer);


		return new SuccessResult("Email verified");
	}

	@Override
	public Result isVerifiedByEmployee(int id) {

	     Employer employer = this.employerDao.getById(id);

	     if(employer == null) {
			 return new ErrorResult("Employer has not found");
		 }
	     //this.employerDao.getById(id).setVerifiedByEmployee(true);
	     employer.setVerifiedByEmployee(true);
	     employerDao.save(employer);

	     return new SuccessResult();
	}
	private Result emailControl(RegisterForEmployerDTO employer) {

		if(!userService.emailControl(employer.getEmail()).isSuccess()) {

			return new ErrorResult("There is a same E-mail in Database");

		}
		return new SuccessResult("E-mail registered");
	}

	private Result checkPasswordsMatch(RegisterForEmployerDTO employer) {

		if(!employer.getPassword().equals(employer.getConfirmPassword())) {

			return new ErrorResult("Confirm Password must to be same with Password");
		}
		return new SuccessResult();
	}
}
