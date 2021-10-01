package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryUploadService;
import kodlamaio.hrms.core.utilities.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hrms.entities.DTOs.CandidateWithCurriculumVitaeDto;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;
    private CloudinaryUploadService cloudinaryUploadService;


    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, CloudinaryUploadService cloudinaryUploadService) {
        this.curriculumVitaeDao = curriculumVitaeDao;
        this.cloudinaryUploadService=cloudinaryUploadService;
    }

    @Override
    public DataResult<List<CurriculumVitae>> getAll() {
        return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(), "CV listed");
    }

    @Override
    public DataResult<List<CurriculumVitae>> getByCandidate_Id(int id) {

        List<CurriculumVitae> result = this.curriculumVitaeDao.getByCandidate_Id(id);

        return new SuccessDataResult<List<CurriculumVitae>>(result, "Data listed");
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {

        this.curriculumVitaeDao.save(curriculumVitae);

        return new SuccessResult("CV added");
    }

    @Override
    public DataResult<List<CandidateWithCurriculumVitaeDto>> getByCandidateWithCurriculumVitae(int id) {
        return new SuccessDataResult<List<CandidateWithCurriculumVitaeDto>>(this.curriculumVitaeDao.getCandidateWithCurriculumVitaeDetails(id), "Data listed");
    }

    @Override
    public DataResult<String> uploadPhoto(Integer id, String filePath) {

        File file = new File(filePath);
        Object object = this.cloudinaryUploadService.upload(file).get("secure_url");

        if((object == null)) {

            return new ErrorDataResult<String>("Failed to load photo! Not found image.", null);

        } else if (!this.curriculumVitaeDao.existsById(id)) {

            return new ErrorDataResult<String>("Failed to load photo! Not found curriculum vitae.", null);
        } else {
            String secure_url = object.toString();
            CurriculumVitae c = this.curriculumVitaeDao.findById(id).get();
            c.setPhotoLink(secure_url);
            this.update(c);
            return new SuccessDataResult<String>("Photo upload successfully.", secure_url);
        }
        }

    @Override
    public Result delete(int id) {

       this.curriculumVitaeDao.getByCandidate_Id(id);

       return new SuccessDataResult<List<CurriculumVitae>>("CV deleted successfully");

    }

    @Override
    public Result update(CurriculumVitae curriculumVitae) {

        this.curriculumVitaeDao.save(curriculumVitae);

        return new SuccessDataResult<List<CurriculumVitae>>("CV updated successfully");
    }

}


