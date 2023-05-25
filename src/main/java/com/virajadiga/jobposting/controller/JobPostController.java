package com.virajadiga.jobposting.controller;

import com.virajadiga.jobposting.model.JobPost;
import com.virajadiga.jobposting.repository.JobPostRepository;
import com.virajadiga.jobposting.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private JobService jobService;

    @GetMapping("/posts")
    public List<JobPost> getJobPosts(){
        return jobPostRepository.findAll();
    }

    @PostMapping("/posts")
    public JobPost addJobPost(@RequestBody JobPost jobPost){
        return jobPostRepository.save(jobPost);
    }

    @GetMapping("/posts/search")
    public List<JobPost> searchPostsByProfile(@RequestParam("profile") String profile){
        return jobService.searchByProfile(profile);
    }
}
