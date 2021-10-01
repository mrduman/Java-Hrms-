package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "curriculum_vitae")
public class CurriculumVitae {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "photo_link")
    private String photoLink;

    @Column(name = "github_address")
    private String githubAddress;

    @Column(name = "linkedin_address")
    private String linkedinAddress;

    @Column(name = "cover_letter")
    private String coverLetter;

   // @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "candidate_id")
  //  @JsonIgnore
    private Candidate candidate;

    @JsonManagedReference
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<ForeignLanguage> languages;

    @JsonManagedReference
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<School> schools;

    @JsonManagedReference
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<ProgrammingLanguage> programmingLanguages;

    @JsonManagedReference
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<JobExperience> jobExperiences;

    @JsonManagedReference
    @OneToMany(mappedBy = "curriculumVitae")
    @JsonIgnore
    private List<ForeignLanguage> foreignLanguages;


}
