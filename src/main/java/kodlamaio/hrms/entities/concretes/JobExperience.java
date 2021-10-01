package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experience")
@Data
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_names")
    private String companyName;

    @Column(name = "status")
    private String status;

    @Column(name = "start_date")
    private LocalDate startedDate;

    @Column(name = "finish_date")
    private LocalDate finishedDate;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "curriculumVitae_id")
    private CurriculumVitae curriculumVitae;


}
