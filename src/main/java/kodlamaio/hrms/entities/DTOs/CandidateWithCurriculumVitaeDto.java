package kodlamaio.hrms.entities.DTOs;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateWithCurriculumVitaeDto {

    private int id;
    private String firstName;
    private String lastName;
    private String photoLink;
    private String githubAddress;
    private String linkedinAddress;
    private String coverLetter;
    private String schoolName;
    private String department;
    private Date startDate;
    private Date finishDate;
    private String LanguageName;
    private int level;
    private String programmingName;
    private String companyName;
    private LocalDate startedDate;
    private LocalDate finishedDate;
}
