package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.DTOs.CandidateWithCurriculumVitaeDto;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;

import javax.xml.crypto.Data;
import java.util.List;

public interface CurriculumVitaeService {

    DataResult<List<CurriculumVitae>> getAll();

    public DataResult<List<CurriculumVitae>> getByCandidate_Id(int id);

    Result add(CurriculumVitae curriculumVitae);

    DataResult<List<CandidateWithCurriculumVitaeDto>> getByCandidateWithCurriculumVitae(int id);

    DataResult<String> uploadPhoto(Integer id, String filePath);

    Result delete(int id);

    Result update(CurriculumVitae curriculumVitae);





}
