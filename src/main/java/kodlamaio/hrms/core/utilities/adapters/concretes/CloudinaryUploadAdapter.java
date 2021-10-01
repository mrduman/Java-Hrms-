package kodlamaio.hrms.core.utilities.adapters.concretes;

import kodlamaio.hrms.core.utilities.adapters.abstracts.CloudinaryUploadService;
import kodlamaio.hrms.externalService.CloudinaryUpload;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
public class CloudinaryUploadAdapter implements CloudinaryUploadService {


    @Override
    public Map<String, Object> upload(File file) {

        CloudinaryUpload cloudinaryUpload = new CloudinaryUpload();
        Map<String, Object> uploadResult = cloudinaryUpload.upload(file);

        return uploadResult;

    }
}
