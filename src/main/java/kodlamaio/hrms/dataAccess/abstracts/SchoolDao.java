package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolDao extends JpaRepository<School, Integer> {


    public List<School> getByCurriculumVitae_Id(int id);

    public List<School> getByCurriculumVitae_IdOrderByFinishDateDesc(int id);


}
