package kodlamaio.hrms.entities.DTOs;

import lombok.Data;

@Data
public class RegisterForCandidateDTO {
	
	private String firstName;
	private String lastName;
	private String password;
	private String confirmPassword;
	private String identityNumber;
	private String birthOfYear;
	private String eMail;
	
	

}
