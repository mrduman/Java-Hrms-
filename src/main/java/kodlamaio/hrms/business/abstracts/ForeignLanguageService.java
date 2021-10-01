package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;

import java.util.List;

public interface ForeignLanguageService {

    DataResult<List<ForeignLanguage>> getAll();

    Result add(ForeignLanguage foreignLanguage);
}
