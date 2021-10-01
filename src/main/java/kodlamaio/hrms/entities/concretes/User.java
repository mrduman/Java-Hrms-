package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table (name="users")

public class User {
	
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
    @Email(message = "Email should be valid")
	@Column(name="email")
	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String email;
	
	@Column(name="password")
	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String password;
	
	public User (String email, String password) {
		
		
		this.email=email;
		this.password=password;
	}

	
	
	
	
}
