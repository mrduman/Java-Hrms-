package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

public interface JobPostDao extends JpaRepository<JobPost, Integer> {

   @Query("From JobPost where isActive=true ")
   List<JobPost>  getByIsActiveTrue();

 // @Query("From JobPost where employer.companyName=:companyName and isActive=true")
  //List<JobPost> getByActiveIsTrueAAndCompanyName(String companyName);

  //@Query("From JobPost where employer.id=:employerId and isActive=true ")
  //List<JobPost> getByActiveIsTrueAndEmployer(int employerId); // 2. method and without query

    List<JobPost> getByIsActiveAndEmployer_Id(boolean isActive, int id);

    List<JobPost> getByIsActiveAndApplicationDeadline(boolean isActive, LocalDate applicationDeadline);

    List<JobPost> getByIsActiveAndCreationDate(boolean isActive, LocalDate creationDate);


    JobPost getById(int id);

    // @Modifying
    //@Transactional
    //@Query("update JobPost j set j.isActive=false where j.id<:id")
    //void setDeactiveJobPost(int id);
  
}
