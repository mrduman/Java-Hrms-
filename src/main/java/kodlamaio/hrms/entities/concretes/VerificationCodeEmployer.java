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
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name="verification_codes_employers")
public class VerificationCodeEmployer extends VerificationCode{
	
	@Column(name="verification_code_id")
	private int verificationCodeId;
	
	
	@Column(name="employer_id")
	private int employerId;

}
