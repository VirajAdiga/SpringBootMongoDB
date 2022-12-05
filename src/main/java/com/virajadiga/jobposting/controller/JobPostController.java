package com.virajadiga.jobposting.controller;

import com.virajadiga.jobposting.model.JobPost;
import com.virajadiga.jobposting.repository.JobPostRepository;
import com.virajadiga.jobposting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostController {

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private SearchRepository searchRepository;

    @GetMapping("/posts")
    public List<JobPost> getJobPosts(){
        return jobPostRepository.findAll();
    }

    @PostMapping("/posts")
    public JobPost addJobPost(@RequestBody JobPost jobPost){
        return jobPostRepository.save(jobPost);
    }

    @GetMapping("/posts/{searchText}")
    public List<JobPost> searchPostsByText(@PathVariable String searchText){
        return searchRepository.searchByText(searchText);
    }
}
