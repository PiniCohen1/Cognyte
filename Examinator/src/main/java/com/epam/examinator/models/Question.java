package com.epam.examinator.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Question {
    private String question;
    private String answer;
}
