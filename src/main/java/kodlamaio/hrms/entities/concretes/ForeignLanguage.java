package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "foreign_language")

public class ForeignLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String LanguageName;

    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "curriculumVitae_id")
    private CurriculumVitae curriculumVitae;
}
