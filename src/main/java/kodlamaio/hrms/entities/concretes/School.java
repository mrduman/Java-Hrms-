package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "school")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","School"})
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String schoolName;

    @Column(name = "department")
    private String department;

    @Column(name = "status")
    private String status;

    @Column(name = "start_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;

    @Column(name = "finish_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date finishDate;

    @Column(name = "graduated")
    private boolean graduated;

    //@JsonIgnore
    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;




}
