package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

import java.util.List;

@RestController
@RequestMapping(value = "/api/jobtitels")
public class JobPositionController {

	private JobPositionService jobPositionService;

	public JobPositionController(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		
		return (DataResult<List<JobPosition>>) this.jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPosition jobPosition) {
		
		return this.jobPositionService.add(jobPosition);

	}
}
