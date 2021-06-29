package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name = "employee_confirm_employers")
public class EmployeeConfirmEmployers extends EmployeeConfirm {

	@Column(name="employee_confirm_id")
	private int id;
	
	@Column(name = "employer_id")
	private int employerId;
}
