package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.DTOs.RegisterForCandidateDTO;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService {

	DataResult<List<Candidate>> getAll();
	Result add(RegisterForCandidateDTO candidate);
	Result identityNumberControl(String identityNumber);
	Result isEmailVerified(int id);
}
