package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.JobExperience;
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
@RequestMapping(value = "/api/jobExperiences")
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @GetMapping(value = "/getAll")
    public DataResult<List<JobExperience>> getAll(){

        return this.jobExperienceService.getAll();

    }

    @GetMapping(value = "getByCurriculumVitae_IdOrderByStartedDateDesc")
    public DataResult<List<JobExperience>> getByCurriculumVitae_IdOrderByStartedDateDesc(int id) {

        return this.jobExperienceService.getByCurriculumVitae_IdOrderByStartedDateDesc(id);

    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobExperience jobExperience) {

        return ResponseEntity.ok(this.jobExperienceService.add(jobExperience));

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){

        Map<String,String> validationErrors = new HashMap<String,String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation Error");

        return errors;
    }
}
