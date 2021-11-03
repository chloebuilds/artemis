package com.artemis.artemis.controllers;

import com.artemis.artemis.models.Job;
import com.artemis.artemis.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class JobController {

        @Autowired
        private JobService jobService;

        // FIND ALL
        @GetMapping("/jobs")
        public Iterable<Job> getJobs() { return jobService.findAllJobs(); }

        // POST
        @PostMapping("/jobs")
        public Job postJob(@Valid @RequestBody Job job) {
            return jobService.createJob(job);
        }

        // GET BY ID
        @GetMapping("/jobs/{jobId}")
        public Optional<Job> getJob(@PathVariable Integer jobId) {

            return jobService.findJob(jobId);
        }

        // DELETE
        @DeleteMapping("/jobs/{jobId}")
        public void deleteJob(@PathVariable Integer jobId) {

            jobService.deleteJob(jobId);
        }

        // EDIT
        @PutMapping("/jobs/{jobId}")
        public Job putJob(@PathVariable Integer jobId,
                            @RequestBody Job job) {
            return jobService.updateJob(jobId, job);
        }
    }

