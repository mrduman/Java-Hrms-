package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	List<Candidate> findByIdentityNumber(String identityNumber);
	Candidate getById(int id);


}