package com.virajadiga.jobposting.controller;

import com.virajadiga.jobposting.service.TechnologyService;
import com.virajadiga.jobposting.model.Technology;

import com.virajadiga.jobposting.repository.TechnologyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TechnologyController {
    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/technologies")
    public List<Technology> getTechnologies(){
        return technologyRepository.findAll();
    }

    @PostMapping("/technologies")
    public Technology addTechnology(@RequestBody Technology technology){
        return technologyRepository.save(technology);
    }

    @PutMapping("/technologies/{id}")
    public Optional<Technology> updateTechnolgy(@PathVariable String id, @RequestBody Technology technology){
        String technologyName = technology.getName();
        return technologyService.updateTechnology(id, technologyName);
    }
}
