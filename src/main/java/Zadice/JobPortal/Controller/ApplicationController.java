package Zadice.JobPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Zadice.JobPortal.Services.ApplicationService;
import Zadice.JobPortal.models.JobApplication;


@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    
    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<JobApplication> getAllApplications(){
        return applicationService.getAll();
    }

    @PostMapping("/{jobId}/{userId}")
    public JobApplication applyToJob(@PathVariable int userId ,@PathVariable int jobId){
      return applicationService.applyToJob(userId,jobId);
    }

    @GetMapping("/user/{userId}")
    public List<JobApplication> getMyApplications(@PathVariable int userId){
        return applicationService.getMyApplication(userId);
    }

    @GetMapping("/job/{jobId}")
    public List<JobApplication> getApplicationsForJob(@PathVariable int jobId){
        return applicationService.getApplicationsForJob(jobId);
    }

    @PutMapping("/{id}/status")
    public JobApplication updateStatus(@PathVariable int id, @RequestParam("status") JobApplication.Status status){
        return applicationService.updateStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable int id){
        applicationService.deleteById(id);
    }

}
