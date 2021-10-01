package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

    Employer getById(int id);

}
