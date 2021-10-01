package kodlamaio.hrms.entities.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForEmployerDTO {

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String companyName;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String webAddress;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String phoneNumber;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String password;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String confirmPassword;

}
