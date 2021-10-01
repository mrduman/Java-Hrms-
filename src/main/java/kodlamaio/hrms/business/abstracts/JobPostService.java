package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobPost;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

public interface JobPostService {


    DataResult<List<JobPost>> getAll();
    DataResult<List<JobPost>> getByIsActiveTrue();
  //  DataResult<List<JobPost>> getByAscDate();
 //   DataResult<List<JobPost>> getByActiveIsTrueDay(int day);
  //  DataResult<List<JobPost>> getByCompanyNameActive(String companyName);
    //DataResult<List<JobPost>> getByActiveIsTrueAndEmployer(int employerId);

    DataResult<List<JobPost>> getByIsActiveAndEmployer_Id(boolean isActive, int id);

    DataResult<List<JobPost>>getByIsActiveAndApplicationDeadline(boolean isActive, LocalDate applicationDeadline);
    DataResult<List<JobPost>> getByIsActiveAndCreationDate(boolean isActive, LocalDate creationDate);

    Result add(JobPost jobPost);
    Result changeActiveStatus(boolean status, int jobPostId);
    Result deleteJobPost(int jobPostId);


  //  Result setDeactiveJobPost(int id);





}
