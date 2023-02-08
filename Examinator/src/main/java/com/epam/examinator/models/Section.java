package com.epam.examinator.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Section {
    private String title;
    private List<Question> questions;

}
