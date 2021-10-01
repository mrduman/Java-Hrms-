package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.DTOs.RegisterForEmployerDTO;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService {
	
	DataResult<List<Employer>> getAll();

	Result add(RegisterForEmployerDTO employer);
	Result isEmailVerified(int id);
	Result isVerifiedByEmployee(int id);


}


