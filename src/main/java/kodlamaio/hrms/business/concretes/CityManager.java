package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {


    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        super();
        this.cityDao = cityDao;
    }


    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Cities had listed");
    }

  /*  @Override
    public Result add(City city) {

        this.cityDao.save(city);

        return new SuccessResult("City saved");
    } */
}
