package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;

import java.util.List;

public interface ProgrammingLanguageService {

    public DataResult<List<ProgrammingLanguage>> getAll();

    public DataResult<List<ProgrammingLanguage>> getByCurriculumVitae_Id(int id);


    Result add(ProgrammingLanguage programmingLanguage);

}
