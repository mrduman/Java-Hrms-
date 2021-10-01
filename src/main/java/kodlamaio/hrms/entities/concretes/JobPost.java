package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","job_titel","cities","employers"})
@Table(name="job_post")
public class JobPost {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

//    private City city;
    @Column(name="min_salary")
    private  int minSalary;

    @Column(name="max_salary")
    private  int maxSalary;

    @NotNull(message = "Name can not be Null")
    @NotBlank
    @Column(name="description")
    private String description;

    @NotNull(message = "Name can not be Null")
    @NotBlank
    @Column(name="free_positions")
    private String freePositions;

    @Column(name="creation_date")
    private LocalDate creationDate;

    @Column(name= "is_active")
    private boolean isActive;

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @ManyToOne()
    @JoinColumn(name = "job_position_id")
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
