package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobPostService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostDao;
import kodlamaio.hrms.entities.concretes.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobPostManager implements JobPostService {

    private JobPostDao jobPostDao;

    @Autowired
    public JobPostManager(JobPostDao jobPostDao) {
        super();
        this.jobPostDao = jobPostDao;
    }


    @Override
    public DataResult<List<JobPost>> getAll() {

        Sort sort = Sort.by(Sort.Direction.ASC, "id"); // Is ilanlarini artarak listelemek
        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.findAll(), "Job Postings has listed");
    }

  /*  @Override
    public DataResult<List<JobPost>> getByActiveIsTrueDay(int day) {
        return new SuccessDataResult<>(this.jobPostDao.getByIsActiveTrue(), "Active Jobs Advertisement had listed");
    }

    @Override
    public DataResult<List<JobPost>> getByCompanyNameActive(String companyName) {
        return new SuccessDataResult<>(this.jobPostDao.getByActiveIsTrueAAndCompanyName(companyName), "Active Jobs Advertisement had according to Company Name listed");
    }

    @Override
    public DataResult<List<JobPost>> getByActiveIsTrueAndEmployer(int employerId) {
        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByActiveIsTrueAndEmployer(employerId));
    } */

    @Override
    public DataResult<List<JobPost>> getByIsActiveAndApplicationDeadline(boolean isActive, LocalDate applicationDeadline) {
        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByIsActiveAndApplicationDeadline(isActive,applicationDeadline), "Job Postings listed for activity Status");
    }

    @Override
    public DataResult<List<JobPost>> getByIsActiveAndCreationDate(boolean isActive, LocalDate creationDate) {
        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByIsActiveAndCreationDate(isActive, creationDate), "Job Postings listed for Creation Date");
    }

    @Override
    public DataResult<List<JobPost>> getByIsActiveTrue() {

        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByIsActiveTrue(),"Active Jobs Advertisement listed");
    }

    @Override
    public DataResult<List<JobPost>> getByIsActiveAndEmployer_Id(boolean isActive, int id) {
        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByIsActiveAndEmployer_Id(isActive,id), "Job postings listed by company id and active status");
    }

    /*   @Override
    public DataResult<List<JobPost>> getByAscDate() {

        return new SuccessDataResult<List<JobPost>>(this.jobPostDao.getByAscDate(), "had listed according to Date ");
    } */

    @Override
    public Result add(JobPost jobPost) {

       this.jobPostDao.save(jobPost);

        return new SuccessResult("Add success");
    }

    @Override
    public Result changeActiveStatus(boolean status, int jobPostId) {

        JobPost jobPost = this.jobPostDao.getById(jobPostId);
        jobPost.setActive(status);
        this.jobPostDao.save(jobPost);
        return new SuccessResult("Status changed");
    }

    @Override
    public Result deleteJobPost(int jobPostId) {

        JobPost jobPost =this.jobPostDao.getById(jobPostId);
        this.jobPostDao.delete(jobPost);
        return new SuccessResult("Job Post deleted");
    }

    //   @Override
   // public Result setDeactiveJobPost(int id) {

     //   this.jobPostDao.setDeactiveJobPost(id);
       // return new Result(true,"Job Posting Disabled ");
    //}

}
