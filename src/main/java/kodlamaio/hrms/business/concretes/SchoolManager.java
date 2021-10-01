package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {

    private SchoolDao schoolDao;


    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        super();
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {

        return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Schools listed");
    }

    @Override
    public DataResult<List<School>> getByCurriculumVitae_Id(int id) {

        List<School> result = this.schoolDao.getByCurriculumVitae_Id(id);

        return new SuccessDataResult<List<School>>(result, " Data listed ");
    }

    @Override
    public DataResult<List<School>> getByCurriculumVitae_IdOrderByFinishDateDesc(int id) {


            return new SuccessDataResult<List<School>>(this.schoolDao.getByCurriculumVitae_IdOrderByFinishDateDesc(id));

    }

    @Override
    public Result add(School school) {


        if (school.isGraduated() == false) {

            school.setStatus("School continues");

            this.schoolDao.save(school);
        }

        return new SuccessResult("School added");
    }
}
