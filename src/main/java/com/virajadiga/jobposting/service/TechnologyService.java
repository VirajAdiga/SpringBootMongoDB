package com.virajadiga.jobposting.service;

import com.virajadiga.jobposting.model.JobPost;
import com.virajadiga.jobposting.model.Technology;
import com.virajadiga.jobposting.repository.JobPostRepository;
import com.virajadiga.jobposting.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

@Service
public class TechnologyService {
    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private JobPostRepository jobPostRepository;

    @Autowired
    private MongoOperations mongoOperations;

    public Optional<Technology> updateTechnology(String id, String technologyName) {

        Optional<Technology> technology = technologyRepository.findById(id);
        technology.ifPresent(tech -> {
            tech.setName(technologyName);
            // Update the technology document in MongoDB
            mongoOperations.save(tech);
        });

        Query query = new Query(Criteria.where("technologies._id").is(id));
        List<JobPost> jobPosts = mongoOperations.find(query, JobPost.class);

        for (JobPost jobPost : jobPosts) {
            // Update the specific Technology object within the JobPost document
            List<Technology> technologies = List.of(jobPost.getTechnologies());
            for (Technology tech : technologies) {
                if (tech.get_id().equals(id)) {
                    tech.setName(technologyName);
                    break;
                }
            }

            // Update the JobPost document in MongoDB
            mongoOperations.save(jobPost);
        }
        return technologyRepository.findById(id);
    }
}
