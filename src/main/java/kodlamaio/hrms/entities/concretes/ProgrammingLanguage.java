package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ProgrammingLanguage,curriculumVitae"})
@Table(name = "programming_language")
public class ProgrammingLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String programmingName;


    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "curriculum_vitae_id")
    private CurriculumVitae curriculumVitae;
}
