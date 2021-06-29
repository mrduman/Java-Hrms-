package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="verification_codes")
public class VerificationCode {
	
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="verified_date")
	private String verifiedDate;
	
	@Column(name="is_verified")
	private boolean isVerified;
	

}
