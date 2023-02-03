package com.epam.examinator.controllers;

import com.epam.examinator.models.Exam;
import com.epam.examinator.generators.ExerciseGenerator;
import com.epam.examinator.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class ExamController {

    @Autowired(required = false)
    private Map<String, ExerciseGenerator>  exerciseGeneratorMap;

    @PostMapping("/exam")
    public Exam calculateExam(@RequestBody Map<String,Integer> examSpec) {
        // example of exam spec
        // { "Math":6, "Eng":3 }
        for (String sectionName : examSpec.keySet()) {
            ExerciseGenerator generator = exerciseGeneratorMap.get(sectionName);
            Integer amount = examSpec.get(sectionName);
            List<Question> section = generator.getRandom(amount);
        }
        return null;
    }
}
