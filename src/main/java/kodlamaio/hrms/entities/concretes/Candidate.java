package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="candidates")

public class Candidate extends User{
	

    @NotNull(message = "Name can not be Null")
	@Column(name="first_name")
	private String firstName;
	
    @NotNull(message = "Last Name can not be Null")
	@Column(name="last_name")
	private String lastName;
	
    @NotNull(message = "İdentity Number can not be Null")
	@Column(name="identity_number")
	private String identityNumber;
	
    @NotNull(message = "Birth Year can not be Null")
	@Column(name="birth_year")
	private String birthOfYear;
    
    public Candidate(String email,String password,String firstName, String lastName, String identityNumber, String  birthOfYear) {
     
    	super(email,password);
        
    	this.firstName = firstName;
        this.lastName = lastName;
        this.identityNumber = identityNumber;
        this.birthOfYear = birthOfYear;
    }
	
	

}
