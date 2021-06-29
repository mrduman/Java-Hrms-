package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobTitel;

public interface JobTitelService {
	
	DataResult<List<JobTitel>>getAll();
	
	Result add(JobTitel jobTitel);
	Result jobTitelControl(String jobTitel);

}
