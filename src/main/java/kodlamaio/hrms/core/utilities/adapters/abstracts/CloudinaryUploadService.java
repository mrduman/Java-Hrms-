package kodlamaio.hrms.core.utilities.adapters.abstracts;

import java.io.File;
import java.util.Map;

public interface CloudinaryUploadService {

    Map<String, Object> upload(File file);

}
