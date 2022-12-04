package com.virajadiga.jobposting.controller;

import com.virajadiga.jobposting.model.JobPost;
import com.virajadiga.jobposting.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    private JobPostRepository jobPostRepository;

    @GetMapping("/posts")
    public List<JobPost> getJobPosts(){
        return jobPostRepository.findAll();
    }

    @PostMapping("/posts")
    public JobPost addJobPost(@RequestBody JobPost jobPost){
        return jobPostRepository.save(jobPost);
    }
}
