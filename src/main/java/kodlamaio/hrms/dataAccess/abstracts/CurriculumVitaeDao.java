package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.DTOs.CandidateWithCurriculumVitaeDto;
import kodlamaio.hrms.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae, Integer> {


    @Query("Select new kodlamaio.hrms.entities.DTOs.CandidateWithCurriculumVitaeDto(c.id,c.firstName,c.lastName,cv.photoLink,cv.githubAddress,cv.linkedinAddress,cv.coverLetter," +
            "s.schoolName,s.department,s.startDate,s.finishDate,fl.LanguageName,fl.level,pl.programmingName,je.companyName,je.startedDate,je.finishedDate)" +
            "From CurriculumVitae cv Inner Join cv.candidate c Inner Join cv.schools s Inner Join cv.programmingLanguages pl Inner Join cv.foreignLanguages fl Inner Join cv.jobExperiences je where c.id=:id")
    List<CandidateWithCurriculumVitaeDto> getCandidateWithCurriculumVitaeDetails(Integer id);

    public List<CurriculumVitae> getByCandidate_Id(int id);



}
