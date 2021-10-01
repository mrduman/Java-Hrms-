package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPostService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/jobPost")
public class JobPostController {

    private JobPostService jobPostService;

    @Autowired
    public JobPostController(JobPostService jobPostService) {
        super();
        this.jobPostService = jobPostService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPost>> getAll(){

        return this.jobPostService.getAll();
    }

    @GetMapping("/getByIsActiveTrue")
    public DataResult<List<JobPost>> getByIsActiveTrue() {

        return this.jobPostService.getByIsActiveTrue();
    }

/*    @GetMapping("/getByCompanyNameActive")
    public DataResult<List<JobPost>> getByCompanyNameActive(@RequestParam String companyName){

        return this.jobPostService.getByCompanyNameActive(companyName);
    } */

   /* @GetMapping("/getByActiveIsTrueDay")
    public DataResult<List<JobPost>> getByActiveIsTrueDay(@RequestParam int day) {

        return this.jobPostService.getByActiveIsTrueDay(day);
    }

    @GetMapping("/getByActiveIsTrueAndEmployer")
    public DataResult<List<JobPost>> getByActiveIsTrueAndEmployer(@RequestParam("employerId") int employerId ,@RequestParam("isActive") boolean isActive){

        return this.jobPostService.getByActiveIsTrueAndEmployer(employerId);
    } */

    @GetMapping("/getByIsActiveAndEmployerId")
    public DataResult<List<JobPost>> getByIsActiveAndEmployer_Id(@RequestParam("isActive") boolean isActive, @RequestParam("id") int id) {

        return this.jobPostService.getByIsActiveAndEmployer_Id(isActive,id);

    }

    @GetMapping("/getByIsActiveAndApplicationDeadline")
    public DataResult<List<JobPost>> getByIsActiveAndApplicationDeadline(@RequestParam("isActive") boolean isActive,@RequestParam("applicationDeadline") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate applicationDeadline) {

        return this.jobPostService.getByIsActiveAndApplicationDeadline(isActive,applicationDeadline);
    }

    @GetMapping("/getByIsActiveAndCreationDate")
    public DataResult<List<JobPost>> getByIsActiveAndCreationDate(@RequestParam("isActive") boolean isActive, @RequestParam("creationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate creationDate){

        return this.jobPostService.getByIsActiveAndCreationDate(isActive,creationDate);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add( @RequestBody JobPost jobPost) {

        return ResponseEntity.ok(this.jobPostService.add(jobPost));
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


    @PostMapping("/changeActiveStatus")
    public Result changeActiveStatus(@RequestParam boolean status, int jobPostId) {

        return this.jobPostService.changeActiveStatus(status,jobPostId);
    }

    @PostMapping("/deleteJobPost")
    public Result deleteJobPost(int jobPostId) {

        return this.jobPostService.deleteJobPost(jobPostId);

    }

   /* @PostMapping("/setDeactiveJobPost")
    public Result setDeactiveJobPost(@RequestParam int id) {

        this.jobPostService.setDeactiveJobPost(id);
        return new SuccessResult();
    } */



}
