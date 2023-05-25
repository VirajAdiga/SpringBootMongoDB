package com.virajadiga.jobposting.service;

import com.virajadiga.jobposting.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    MongoTemplate mongoTemplate;

    public List<JobPost> searchByProfile(String profile){
        Query searchQuery = new Query();
        Criteria criteria = Criteria.where("profile").regex(profile, "i"); // "i" for case-insensitive search
        searchQuery.addCriteria(criteria);

        return mongoTemplate.find(searchQuery, JobPost.class);
    }
}
