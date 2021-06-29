package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitelService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitelDao;
import kodlamaio.hrms.entities.concretes.JobTitel;

@Service
public class JobTitelManager implements JobTitelService{

	private JobTitelDao jobTitelDao;
	
	@Autowired
	public JobTitelManager(JobTitelDao jobTitelDao) {
		super();
		this.jobTitelDao = jobTitelDao;
	}

	@Override
	public DataResult<List<JobTitel>> getAll() {
		
		return new SuccessDataResult<List<JobTitel>>("Job Titel had listed");
	}

	@Override
	public Result add(JobTitel jobTitel) {
		
		if(!jobTitelControl(jobTitel.getTitle()).isSuccess()) {
			
			return new ErrorResult("There is a same Job Titel");
		}
		
		this.jobTitelDao.save(jobTitel);
		return new SuccessResult("Job has added");
	}

	@Override
	public Result jobTitelControl(String jobTitel) {
		
		List<JobTitel> jobTitels = this.jobTitelDao.findByJobTitel(jobTitel);
		
		if(!(jobTitels.isEmpty())) {
			
			return new ErrorResult("There is a same Job Titel");
		}
		
		return new SuccessResult();
		
	}

}
