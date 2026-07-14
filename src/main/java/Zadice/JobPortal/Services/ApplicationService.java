package Zadice.JobPortal.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Zadice.JobPortal.models.Job;
import Zadice.JobPortal.models.JobApplication;
import Zadice.JobPortal.models.User;
import Zadice.JobPortal.repository.ApplicationRepository;
import Zadice.JobPortal.repository.JobRepository;
import Zadice.JobPortal.repository.UserRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobRepository jobRepository;

    public JobApplication applyToJob(int user_id, int job_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Job job = jobRepository.findById(job_id)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        if (applicationRepository.existsByUserAndJob(user, job)) {
            throw new RuntimeException("Already applied to this job");
        }

        JobApplication application = new JobApplication();
        application.setUser(user);
        application.setJob(job);
        application.setStatus(JobApplication.Status.PENDING);
        return applicationRepository.save(application);
    }

    public List<JobApplication> getAll() {
        return applicationRepository.findAll();
    }

    public List<JobApplication> getMyApplication(int user_id) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return applicationRepository.findByUser(user);
    }

    public List<JobApplication> getApplicationsForJob(int job_id) {
        Job job = jobRepository.findById(job_id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return applicationRepository.findByJob(job);
    }

    public JobApplication updateStatus(int id, JobApplication.Status status) {
        JobApplication app = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));
        app.setStatus(status);
        return applicationRepository.save(app);
    }

    public void deleteById(int id) {
        applicationRepository.deleteById(id);
    }
}
