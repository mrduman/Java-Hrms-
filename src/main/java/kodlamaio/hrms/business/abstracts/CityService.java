package kodlamaio.hrms.business.abstracts;


import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.core.utilities.result.DataResult;
import java.util.List;

public interface CityService  {

    DataResult<List<City>> getAll();
  //  Result add(City city);
}
