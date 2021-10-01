package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(), "Job Experience listed");
    }

    @Override
    public DataResult<List<JobExperience>> getByCurriculumVitae_IdOrderByStartedDateDesc(int id) {

        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.getByCurriculumVitae_IdOrderByStartedDateDesc(id));

    }

    @Override
    public Result add(JobExperience jobExperience) {

        if(jobExperience.getFinishedDate()  == null) {

            jobExperience.setStatus("still working");

        }

        this.jobExperienceDao.save(jobExperience);

        return new SuccessResult("Job Experience Added");
    }
}
