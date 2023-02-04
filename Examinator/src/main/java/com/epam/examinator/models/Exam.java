package com.epam.examinator.models;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    private String title;
    private List<Section> sections = new ArrayList<>();

    public void addSection(Section section) {
        sections.add(section);
    }
}
