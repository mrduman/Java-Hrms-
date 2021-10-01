package kodlamaio.hrms.entities.concretes;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_post"})
@Table(name="job_titel")
public class JobPosition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;

	@JsonIgnore
	@Column(name = "updated_date")
	private LocalDate updateDate;

	@JsonIgnore
	@OneToMany(mappedBy = "jobPosition")
	private List<JobPost> jobPosts;
}
