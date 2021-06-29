package kodlamaio.hrms.entities.DTOs;

import lombok.Data;

@Data
public class RegisterForEmployerDTO {
	
	private String companyName;
	private String webAddress;
	private String phoneNumber;
	private String eMail;
	private String password;
	private String confirmPassword;

}
