package com.epam.examinator.controllers;

import com.epam.examinator.services.QuestionGenerator;
import com.epam.examinator.models.Exam;

import java.util.Map;

// TODO : Create Rest API for class methods
public class ExamController {

    // TODO : Initialize this
    private final Map<String, QuestionGenerator>  questionsGeneratorMap;

    /**
     * Method will generate and return new Exam.
     * following Exam JSON format { "Math":6, "Eng":3 }
     * */
    // TODO : create Post service for entry api/exam
    public Exam calculateExam(Map<String,Integer> examSpec) {
        Exam exam = new Exam();

        // TODO : Create the exam

        return exam;
    }
}
