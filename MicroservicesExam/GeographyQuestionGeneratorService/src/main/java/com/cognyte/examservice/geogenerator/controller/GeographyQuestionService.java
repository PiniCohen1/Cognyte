package com.cognyte.examservice.geogenerator.controller;

import com.cognyte.examservice.geogenerator.dao.GeographyQuestionRepo;
import com.cognyte.examservice.geogenerator.model.GeographyQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/")
public class GeographyQuestionService {

    GeographyQuestionRepo repo;

    public GeographyQuestionService(@Autowired GeographyQuestionRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("questions/random")
    public List<GeographyQuestion> getRandomQuestions(@RequestParam int amount){
        List<GeographyQuestion> all = repo.findAll();
        Collections.shuffle(all);
        return all.subList(0,amount);
    }
}
