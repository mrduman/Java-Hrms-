package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import kodlamaio.hrms.core.utilities.result.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.DTOs.RegisterForCandidateDTO;
import kodlamaio.hrms.entities.concretes.Candidate;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/candidates")
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {
		
		return (DataResult<List<Candidate>>) this.candidateService.getAll();
		
	}
	@GetMapping("emailVerified")
	public Result emailVerified(int id) {

		return candidateService.isEmailVerified(id);
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody RegisterForCandidateDTO candidate) {
		
		return ResponseEntity.ok(this.candidateService.add(candidate));
		
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












