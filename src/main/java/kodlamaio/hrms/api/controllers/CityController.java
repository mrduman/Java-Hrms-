package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cities")
public class CityController {


    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    public DataResult<List<City>> getAll(@RequestParam String city) {

        return this.cityService.getAll();
    }
}
