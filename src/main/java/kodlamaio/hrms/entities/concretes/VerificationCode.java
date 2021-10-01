package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="verification_codes")
public class VerificationCode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="verified_date")
	private String verifiedDate;
	
	@Column(name="is_verified")
	private boolean isVerified;
	

}
