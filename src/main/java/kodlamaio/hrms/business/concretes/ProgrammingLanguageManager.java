package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ProgrammingLanguageDao;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

    private ProgrammingLanguageDao programmingLanguageDao;

    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageDao programmingLanguageDao) {
        this.programmingLanguageDao = programmingLanguageDao;
    }

    @Override
    public DataResult<List<ProgrammingLanguage>> getAll() {
        return new SuccessDataResult<List<ProgrammingLanguage>>(this.programmingLanguageDao.findAll(), "Programming Language listed");
    }

    @Override
    public DataResult<List<ProgrammingLanguage>> getByCurriculumVitae_Id(int id) {

        List<ProgrammingLanguage> result = this.programmingLanguageDao.getByCurriculumVitae_Id(id);

        return new DataResult<List<ProgrammingLanguage>>(result,true);
    }

    @Override
    public Result add(ProgrammingLanguage programmingLanguage) {

        this.programmingLanguageDao.save(programmingLanguage);

        return new SuccessResult("Programming Language added");
    }
}
