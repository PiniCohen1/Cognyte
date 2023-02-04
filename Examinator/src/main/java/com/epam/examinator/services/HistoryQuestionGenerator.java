package com.epam.examinator.services;

import com.epam.examinator.models.Question;

import java.util.ArrayList;
import java.util.List;

public class HistoryQuestionGenerator implements QuestionGenerator {

    private final List<Question> questions = new ArrayList<>(List.of(
            Question.builder()
                    .question("What is considered the largest empire in history?")
                    .answer("The Mongol Empire").build(),
            Question.builder()
                    .question("Where did Albert Einstein live before moving to the United States?")
                    .answer("Germany").build(),
            Question.builder()
                    .question("What year was the first iPhone released?")
                    .answer("2007").build(),
            Question.builder()
                    .question("What year did the Berlin Wall fall?")
                    .answer("1989").build()
    ));

    @Override
    public Question getRandomQuestion() {
        // TODO : get randomize question
    }

    @Override
    public List<Question> getRandomQuestions(int amount) {
        // TODO :get specific amount of questions from list
    }
}
