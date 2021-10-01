package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="employees")

public class Employee extends User{
	
	@Column(name="first_name")
	@NotNull(message = "Name can not be Null")
	@NotBlank
	private String firstName;

	@NotNull(message = "Name can not be Null")
	@NotBlank
	@Column(name="last_name")
	private String lastName;

	

	
}
