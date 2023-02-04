package com.epam.examinator.services;

import com.epam.examinator.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("math")
public class MathQuestionGenerator implements QuestionGenerator {
    @Override
    public Question getRandomQuestion() {
        // TODO : create and return random question
    }

    @Override
    public List<Question> getRandomQuestions(int amount) {
        // TODO : return amount of random questions from list
    }
}
