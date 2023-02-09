package com.cognyte.examservice.mathgenerator.controller;

import com.cognyte.examservice.mathgenerator.service.MathQuestionGenerator;
import com.cognyte.examservice.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MathQuestionController {

    private final MathQuestionGenerator mathQuestionGenerator;

    public MathQuestionController(@Autowired MathQuestionGenerator mathQuestionGenerator) {
        this.mathQuestionGenerator = mathQuestionGenerator;
    }

    @GetMapping("/api/questions/random")
    public List<Question> getRandomQuestions(@RequestParam int amount) {
        return mathQuestionGenerator.getRandomQuestions(amount);
    }
}
