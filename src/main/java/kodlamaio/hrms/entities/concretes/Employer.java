package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name="employers")

public class Employer extends User {
	
	@Column(name="company_name")
	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String companyName;
	
	@Column(name="web_address")
	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String webAddress;
	
	@Column(name="phone_number")
	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String phoneNumber;

	@Column(name="is_email_verified")
	private boolean isEmailVerified = false;

	@Column(name="is_verified_by_employee")
	private boolean isVerifiedByEmployee;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobPost> jobPosts;


	
	public Employer(String email, String password, String companyName, String webAddress, String phoneNumber ) {
		
		super(email,password);
		
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.webAddress = webAddress;
	}
	

}
