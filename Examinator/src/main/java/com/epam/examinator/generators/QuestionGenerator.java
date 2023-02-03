package com.epam.examinator.generators;

import com.epam.examinator.models.Question;

import java.util.ArrayList;
import java.util.List;

public interface QuestionGenerator {
    Question getRandomQuestion();

    default List<Question> getRandomQuestions(int amount) {
        var questions = new ArrayList<Question>();
        for (int i=0; i< amount; i++) {
            questions.add(getRandomQuestion());
        }
        return questions;
    }
}
