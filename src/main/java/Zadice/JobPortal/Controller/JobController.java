package Zadice.JobPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Zadice.JobPortal.Services.JobService;
import Zadice.JobPortal.models.Job;
import Zadice.JobPortal.models.Job.JobType;
import Zadice.JobPortal.models.Job.categoryType;

@RestController
@RequestMapping("/api/jobs")
public class JobController {

    @Autowired 
    private JobService jobService;

    @GetMapping
    public List<Job> getAllActiveJobs(){
        return jobService.getAllActiveJobs();
    }

    @PostMapping
    public Job createJob(@RequestBody Job job){
        return jobService.createJob(job);
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable int id){
        return jobService.getJobById(id);
    }

    @GetMapping("/category/{category}")
    public List<Job> getJobsByCategory(@PathVariable categoryType category){
        return jobService.getJobsByCategory(category);
    }

    @GetMapping("/type/{type}")
    public List<Job> getJobsByType(@PathVariable JobType type){
        return jobService.getJobsByType(type);
    }

    @GetMapping("/location/{location}")
    public List<Job> getJobsByLocation(@PathVariable String location){
        return jobService.getJobsByLocation(location);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable int id,@RequestBody Job job){
        return jobService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable int id){
         jobService.deleteJob(id);
    }

}
