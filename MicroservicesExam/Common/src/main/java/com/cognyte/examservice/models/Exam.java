package com.cognyte.examservice.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Exam {
    private String title;
    private List<Section> sections = new ArrayList<>();

    public void addSection(Section section) {
        sections.add(section);
    }
}
