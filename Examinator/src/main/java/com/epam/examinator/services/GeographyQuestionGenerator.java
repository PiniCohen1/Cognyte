package com.epam.examinator.services;

import com.epam.examinator.models.Question;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service("geo")
public class GeographyQuestionGenerator implements QuestionGenerator{
    private final List<Question> questions = new ArrayList<>(List.of(
            Question.builder()
                    .question("Is China is the largest country in the world?")
                    .answer("False. Russia is the world's largest country").build(),
            Question.builder()
                    .question("What is the largest sea in the world?")
                    .answer("The Caspian Sea").build(),
            Question.builder()
                    .question("Where is the Sun not visible for 186 days a year?")
                    .answer("The North Pole").build(),
            Question.builder()
                    .question("What is the smallest country?")
                    .answer("Vatican City").build(),
            Question.builder()
                    .question("Which country has the longest coastline in the world?")
                    .answer("Canada").build()
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
        return questions.subList(0, amount);    }
}
