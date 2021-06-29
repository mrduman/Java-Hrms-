package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitelService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobTitel;

import java.util.List;

@RestController
@RequestMapping("/api/jobtitels")
public class JobTitelController {

	private JobTitelService jobTitelService;

	public JobTitelController(JobTitelService jobTitelService) {
		super();
		this.jobTitelService = jobTitelService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobTitel>> getAll(){
		
		return (DataResult<List<JobTitel>>) this.jobTitelService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitel jobTitel) {
		
		return this.jobTitelService.add(jobTitel);
	}
}
