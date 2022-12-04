package com.virajadiga.jobposting.repository;

import com.virajadiga.jobposting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String> {

}
