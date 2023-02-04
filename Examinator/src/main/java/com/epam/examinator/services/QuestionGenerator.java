package com.epam.examinator.services;

import com.epam.examinator.models.Question;

import java.util.List;

public interface QuestionGenerator {
    Question getRandomQuestion();

    List<Question> getRandomQuestions(int amount);
}
