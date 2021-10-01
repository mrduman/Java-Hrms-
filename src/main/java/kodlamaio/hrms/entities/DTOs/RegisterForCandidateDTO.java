package kodlamaio.hrms.entities.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForCandidateDTO {
	
	private String firstName;
	private String lastName;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String password;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String confirmPassword;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String identityNumber;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String birthOfYear;

	@Email(message = "Email should be valid")
	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String email;
	
	

}
