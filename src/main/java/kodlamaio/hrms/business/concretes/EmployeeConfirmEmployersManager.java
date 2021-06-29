package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployeeConfirmEmployersService;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployers;

@Service
public class EmployeeConfirmEmployersManager implements EmployeeConfirmEmployersService{

	@Override
	public Result emailConfirm(EmployeeConfirmEmployers employeeConfirmEmployers) {
		
		if(!employeeConfirmEmployers.isConfirmed()) {
			
			return new ErrorResult("E-Mail must be confirm");
			
		}
		
		return new SuccessResult();
	}

	@Override
	public Result employeeConfirmEmployers(EmployeeConfirmEmployers confirmEmployers) {
		
		if(!confirmEmployers.isConfirmed()) {
			
			return new ErrorResult("Employee must to confirm to Employers");
		}
		return new SuccessResult();
	}

}
