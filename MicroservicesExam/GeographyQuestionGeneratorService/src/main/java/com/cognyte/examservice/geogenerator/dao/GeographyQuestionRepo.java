package com.cognyte.examservice.geogenerator.dao;

import com.cognyte.examservice.geogenerator.model.GeographyQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeographyQuestionRepo extends JpaRepository<GeographyQuestion,Integer> {
}
