package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer> {

    public List<ProgrammingLanguage> getByCurriculumVitae_Id(int id);

}
