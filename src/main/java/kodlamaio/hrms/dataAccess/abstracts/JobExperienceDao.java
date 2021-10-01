package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    public List<JobExperience> getByCurriculumVitae_IdOrderByStartedDateDesc(int id);

}
