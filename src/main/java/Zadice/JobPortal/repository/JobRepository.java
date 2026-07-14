package Zadice.JobPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Zadice.JobPortal.models.Job;
import Zadice.JobPortal.models.Job.JobType;
import Zadice.JobPortal.models.Job.categoryType;



@Repository
public interface JobRepository extends JpaRepository <Job,Integer> {
    
    List<Job>findByActive(boolean active);
    List<Job>findByCategory(categoryType category);
    List<Job>findByType(JobType type);
    List<Job>findByLocation(String location);
    List<Job>findByCompany(String company);


}
