package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.entities.DTOs.CandidateWithCurriculumVitaeDto;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
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
@RequestMapping(value = "/api/curriculumVitae")
public class CurriculumVitaeController {

    private CurriculumVitaeService curriculumVitaeService;

    public CurriculumVitaeController(CurriculumVitaeService curriculumVitaeService) {
        this.curriculumVitaeService = curriculumVitaeService;
    }

    @GetMapping(value = "/getAll")
    public DataResult<List<CurriculumVitae>> getAll(){

        return this.curriculumVitaeService.getAll();

    }

    @GetMapping(value = "/getByCandidateWithCurriculumVitae")
    public DataResult<List<CandidateWithCurriculumVitaeDto>> getByCandidateWithCurriculumVitae(int id){

        return this.curriculumVitaeService.getByCandidateWithCurriculumVitae(id);

    }

    @GetMapping(value = "/getByCandidate_Id")
    public DataResult<List<CurriculumVitae>> getByCandidate_Id(int id) {

        return this.curriculumVitaeService.getByCandidate_Id(id);

    }

    @PostMapping(value = "/uploadPhoto")
    public DataResult<String> uploadPhoto(@RequestParam(name = "id") Integer id,@RequestParam(name = "filePath") String filePath){

        return this.curriculumVitaeService.uploadPhoto(id,filePath);
    }

    @PostMapping(value = "/delete")
    public Result delete(int id) {

        return this.curriculumVitaeService.delete(id);
    }

    @PostMapping(value = "/update")
    public Result update(CurriculumVitae curriculumVitae) {

        return this.curriculumVitaeService.update(curriculumVitae);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody CurriculumVitae curriculumVitae){

        return ResponseEntity.ok(this.curriculumVitaeService.add(curriculumVitae));

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
