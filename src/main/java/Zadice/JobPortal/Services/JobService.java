package Zadice.JobPortal.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Zadice.JobPortal.models.Job;
import Zadice.JobPortal.models.Job.JobType;
import Zadice.JobPortal.models.Job.categoryType;
import Zadice.JobPortal.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job createJob(Job job) {
        job.setActive(true);
        return jobRepository.save(job);
    }

    public List<Job> getAllActiveJobs() {
        return jobRepository.findByActive(true);
    }

    public Job getJobById(int id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    public List<Job> getJobsByCategory(categoryType category) {
        return jobRepository.findByCategory(category);
    }

    public List<Job> getJobsByType(JobType type) {
        return jobRepository.findByType(type);
    }

    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location);
    }

    public List<Job> getJobsByCompany(String company) {
        return jobRepository.findByCompany(company);
    }

    public Job updateJob(int id, Job updatedJob) {
        Job job = getJobById(id);
        job.setTitle(updatedJob.getTitle());
        job.setCompany(updatedJob.getCompany());
        job.setLocation(updatedJob.getLocation());
        job.setDescription(updatedJob.getDescription());
        job.setSalary(updatedJob.getSalary());
        job.setType(updatedJob.getType());
        job.setCategory(updatedJob.getCategory());
        return jobRepository.save(job);
    }

    public void deleteJob(int id) {
        jobRepository.deleteById(id);
    }
}
