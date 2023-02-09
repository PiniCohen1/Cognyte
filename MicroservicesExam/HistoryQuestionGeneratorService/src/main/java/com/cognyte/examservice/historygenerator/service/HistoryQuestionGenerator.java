package com.cognyte.examservice.historygenerator.service;

import com.cognyte.examservice.QuestionGenerator;
import com.cognyte.examservice.models.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service("history")
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
                    .answer("1989").build(),
            Question.builder()
                    .question("What year did Google launch?")
                    .answer("1998").build(),
            Question.builder()
                    .question("What year did the Internet become available to the public?")
                    .answer("1993").build(),
            Question.builder()
                    .question("What year was Nelson Mandela freed from prison?")
                    .answer("1990").build()
    ));

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int i = random.nextInt(questions.size());
        return questions.get(i);
    }

    @Override
    public List<Question> getRandomQuestions(int amount) {
        Collections.shuffle(questions);
        return questions.subList(0, amount);
    }
}
