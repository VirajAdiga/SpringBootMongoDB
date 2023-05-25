package com.virajadiga.jobposting.repository;

import com.virajadiga.jobposting.model.Technology;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository  extends MongoRepository<Technology, String> {

}
