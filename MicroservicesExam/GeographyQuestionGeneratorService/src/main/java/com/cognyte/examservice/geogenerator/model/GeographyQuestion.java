package com.cognyte.examservice.geogenerator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class GeographyQuestion {
    @Id
    //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;
    private String answer;

}
