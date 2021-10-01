package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService {

    DataResult<List<JobExperience>> getAll();

    public DataResult<List<JobExperience>> getByCurriculumVitae_IdOrderByStartedDateDesc(int id);

    Result add(JobExperience jobExperience);

}
