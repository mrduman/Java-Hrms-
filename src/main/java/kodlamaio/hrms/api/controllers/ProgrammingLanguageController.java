package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ProgrammingLanguage;
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
@RequestMapping(value = "/api/programmingLanguages")
public class ProgrammingLanguageController {

    private ProgrammingLanguageService programmingLanguageService;

    public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
        this.programmingLanguageService = programmingLanguageService;
    }

    @GetMapping(value = "/programmingLanguages")
    public DataResult<List<ProgrammingLanguage>> getAll(){

        return this.programmingLanguageService.getAll();
    }

    @GetMapping(value = "getByCurriculumVitaeId")
    public DataResult<List<ProgrammingLanguage>> getByCurriculumVitae_Id(@RequestParam int id) {

        return this.programmingLanguageService.getByCurriculumVitae_Id(id);
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody ProgrammingLanguage programmingLanguage) {

        return ResponseEntity.ok(this.programmingLanguageService.add(programmingLanguage));

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
