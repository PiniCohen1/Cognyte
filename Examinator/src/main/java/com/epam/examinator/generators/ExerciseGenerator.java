package com.epam.examinator.generators;

import com.epam.examinator.models.Question;

import java.util.List;

public interface ExerciseGenerator {
    List<Question> getRandom(int amount);
}
