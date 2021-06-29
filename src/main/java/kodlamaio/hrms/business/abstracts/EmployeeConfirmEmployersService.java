package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.EmployeeConfirmEmployers;

public interface EmployeeConfirmEmployersService {

	Result emailConfirm(EmployeeConfirmEmployers employeeConfirmEmployers);
	Result employeeConfirmEmployers(EmployeeConfirmEmployers confirmEmployers);
}
