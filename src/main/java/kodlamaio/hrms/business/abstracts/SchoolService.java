package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {

    public DataResult<List<School>> getAll();

    public DataResult<List<School>> getByCurriculumVitae_Id(int id);

    public DataResult<List<School>> getByCurriculumVitae_IdOrderByFinishDateDesc(int id);

    public Result add(School school);
}
