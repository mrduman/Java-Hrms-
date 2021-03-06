package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
@Table(name="verification_codes_candidates")
public class VerificationCodeCandidate extends VerificationCode{

	@Column(name="verification_code_id")
	private int verificationCodeId;
	
	@Column(name = "candidate_id")
	private int candidateId;

	public int getVerificationCodeId() {
		return verificationCodeId;
	}

	public void setVerificationCodeId(int verificationCodeId) {
		this.verificationCodeId = verificationCodeId;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
}
