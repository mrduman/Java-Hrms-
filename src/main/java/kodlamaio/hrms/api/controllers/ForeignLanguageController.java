package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ForeignLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ForeignLanguage;
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
@RequestMapping(value = "/api/foreignLanguages")
public class ForeignLanguageController {

    private ForeignLanguageService foreignLanguageService;

    @Autowired
    public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
        this.foreignLanguageService = foreignLanguageService;
    }

    @GetMapping(value = "/foreignLanguage")
    public DataResult<List<ForeignLanguage>> getAll(){

        return this.foreignLanguageService.getAll();
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@Valid @RequestBody ForeignLanguage foreignLanguage) {

        return ResponseEntity.ok(this.foreignLanguageService.add(foreignLanguage));

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
