package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/school")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {

        this.schoolService = schoolService;
    }

    @GetMapping(value = "/getByCurriculumVitae_Id")
    public DataResult<List<School>> getByCurriculumVitae_Id(@RequestParam int id) {

        return this.schoolService.getByCurriculumVitae_Id(id);
    }

    @GetMapping(value = "getByCurriculumVitae_IdOrderByFinishDateDesc" )
    public DataResult<List<School>> getByCurriculumVitae_IdOrderByFinishDateDesc(@RequestParam int id) {

        return this.schoolService.getByCurriculumVitae_IdOrderByFinishDateDesc(id);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody School school){

        return ResponseEntity.ok(this.schoolService.add(school));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation Errors");

        return errors;
    }
}
