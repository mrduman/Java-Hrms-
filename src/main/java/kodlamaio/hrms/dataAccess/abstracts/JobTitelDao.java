package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobTitel;

public interface JobTitelDao extends JpaRepository<JobTitel, Integer>{
	
	List<JobTitel>  findByJobTitel(String jobTitel);

}
