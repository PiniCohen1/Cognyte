package com.epam.examinator.controllers;

import com.epam.examinator.models.Exam;
import com.epam.examinator.models.Question;
import com.epam.examinator.models.Section;
import com.epam.examinator.services.QuestionGenerator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/")
public class ExamController {

    private final Map<String, QuestionGenerator> questionsGeneratorMap;

    public ExamController(@Autowired Map<String, QuestionGenerator> questionsGeneratorMap) {
        this.questionsGeneratorMap = questionsGeneratorMap;
    }

    /**
     * Method will generate and return new Exam.
     * following Exam JSON format { "Math":6, "History":3 }
     * */
    @PostMapping("exam")
    public Exam calculateExam(@RequestBody Map<String,Integer> examSpec) {
        Exam exam = new Exam();
        exam.setTitle("Cognyte Exam");

        for (String sectionName : examSpec.keySet()) {
            QuestionGenerator generator = questionsGeneratorMap.get(sectionName);
            Integer amount = examSpec.get(sectionName);
            List<Question> questions = generator.getRandomQuestions(amount);
            exam.addSection(new Section(sectionName,questions));
        }
        return exam;
    }
}
