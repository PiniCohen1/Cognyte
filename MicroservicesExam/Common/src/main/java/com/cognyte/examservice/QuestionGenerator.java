package com.cognyte.examservice;

import com.cognyte.examservice.models.Question;

import java.util.List;

public interface QuestionGenerator {
    Question getRandomQuestion();

    List<Question> getRandomQuestions(int amount);
}
