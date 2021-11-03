package com.artemis.artemis.services;

import com.artemis.artemis.models.Job;
import com.artemis.artemis.repos.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class JobService {
    @Autowired
    private JobRepo jobRepo;

    public Iterable<Job> findAllJobs() { return jobRepo.findAll(); }

    public Job createJob(Job job) { return jobRepo.save(job); }

    public Optional<Job> findJob(Integer jobId) {
        Optional<Job> optJob = jobRepo.findById(jobId);
        if (optJob.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found");
        }
        return optJob;
    }

    public void deleteJob(Integer jobId) {
        Optional<Job> optJob = jobRepo.findById(jobId);
        if (optJob.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found");
        }
        jobRepo.deleteById(jobId);
    }

    public Job updateJob(Integer jobId, Job job) {
        Optional<Job> optJob = jobRepo.findById(jobId);
        if (optJob.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Job not found");
        }
        Job jobToUpdate = optJob.get();
        jobToUpdate.setJobTitle(job.getJobTitle());
        jobToUpdate.setCompany(job.getCompany());
        jobToUpdate.setLocation(job.getLocation());
        jobToUpdate.setWorkType(job.getWorkType());
        jobToUpdate.setJobDescription(job.getJobDescription());
        jobToUpdate.setSalaryRange(job.getSalaryRange());
        jobToUpdate.setExperienceLevel(job.getExperienceLevel());
        jobToUpdate.setTechStack(job.getTechStack());
        jobToUpdate.setRequirements(job.getRequirements());
        jobToUpdate.setPostDate(job.getPostDate());
        jobToUpdate.setArchived(job.getArchived());
        return jobRepo.save(jobToUpdate);
    }
}
