package com.cognyte.examservice.historygenerator.controller;

import com.cognyte.examservice.historygenerator.service.HistoryQuestionGenerator;
import com.cognyte.examservice.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/")
public class HistoryQuestionController {


    private final HistoryQuestionGenerator generator;

    public HistoryQuestionController(@Autowired HistoryQuestionGenerator generator) {
        this.generator = generator;
    }

    @RequestMapping("questions/random")
    public List<Question> getQuestions(@RequestParam int amount) {
        return generator.getRandomQuestions(amount);
    }
}
