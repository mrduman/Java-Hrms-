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


import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.DTOs.RegisterForEmployerDTO;
import kodlamaio.hrms.entities.concretes.Employer;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/employers")
public class EmployersController {
	

	private EmployerService employerService;
	

	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {
	
		return (DataResult<List<Employer>>) this.employerService.getAll();
	}

	@GetMapping("/emailConfirm")
	public Result emailConfirm(int id){

		return this.employerService.isEmailVerified(id);
	}

	@GetMapping("/employeeConfinrm")
	public Result employeeConfirm(int id){

		return this.employerService.isVerifiedByEmployee(id);
	}

	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody RegisterForEmployerDTO employer) {
		
		return ResponseEntity.ok(this.employerService.add(employer));
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
	

