package Zadice.JobPortal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Zadice.JobPortal.models.Job;
import Zadice.JobPortal.models.JobApplication;
import Zadice.JobPortal.models.User;

@Repository
public interface ApplicationRepository extends JpaRepository<JobApplication, Integer> {
    List<JobApplication> findByUser(User user);
    List<JobApplication> findByJob(Job job);
    boolean existsByUserAndJob(User user, Job job);
}
