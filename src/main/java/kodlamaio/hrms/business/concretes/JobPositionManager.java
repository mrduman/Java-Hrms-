package kodlamaio.hrms.business.concretes;

import java.util.List;

import kodlamaio.hrms.core.utilities.helpers.BusinessRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"Job Titel had listed");


	}

	@Override
	public Result add(JobPosition jobPosition) {


		Result result = BusinessRule.run(jobTitleControl(jobPosition.getTitle()));

		if(!result.isSuccess()){
			return result;
		}
		
	/*	if(!jobPositionControl(jobPosition.getTitle()).isSuccess()) {
			
			return new ErrorResult("There is a same Job Position");
		} */


		this.jobPositionDao.save(jobPosition);
		return new SuccessResult("Job has added");
	}

	@Override
	public Result delete(JobPosition jobPosition) {

		jobPositionDao.delete(jobPosition);
		return new SuccessResult("Delete Success");
	}

	@Override
	public Result update(JobPosition jobPosition) {

		jobPositionDao.save(jobPosition);
		return new SuccessResult("Update Success");
	}

	@Override
	public Result jobTitleControl(String title) {
		
		List<JobPosition> jobPositions = this.jobPositionDao.getByTitle(title);
		
		if(!(jobPositions.isEmpty())) {
			
			return new ErrorResult("There is a same Job Position");
		}
		
		return new SuccessResult();
		
	}

}
