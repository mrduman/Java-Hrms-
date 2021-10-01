package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "CurriculumVitae","curriculumVitae"})
@Table(name="candidates")

public class Candidate extends User{
	

    @NotNull(message = "Name can not be Null")
	@Column(name="first_name")
    @NotBlank
	private String firstName;
	
    @NotNull(message = "Last Name can not be Null")
	@Column(name="last_name")
    @NotBlank
	private String lastName;
	
    @NotNull(message = "İdentity Number can not be Null")
	@Column(name="identity_number")
    @NotBlank
	private String identityNumber;
	
    @NotNull(message = "Birth Year can not be Null")
	@Column(name="birth_year")
    @NotBlank
	private String birthOfYear;

    @Column(name= "is_email_verified")
    private boolean isEmailVerified=false;


    @JsonManagedReference
    @OneToMany(mappedBy = "candidate")
    @JsonIgnore
    private List<CurriculumVitae> curriculumVitae;
    
    public Candidate(String  birthOfYear,String firstName, String identityNumber,String lastName,String email,String password) {
     
    	super(email,password);

        this.birthOfYear = birthOfYear;
    	this.firstName = firstName;
    	this.identityNumber = identityNumber;
        this.lastName = lastName;
        this.isEmailVerified = false;

    }
	
	

}
