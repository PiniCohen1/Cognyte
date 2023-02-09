package com.cognyte.firststarter.services;

import com.cognyte.firststarter.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CognyteMainService {

    @Autowired
    private List<Validator> validators;
    public void work() {

        // Lambda syntax
        //validators.forEach(validator -> validator.validate());

        // Same result with Method Reference
        validators.forEach(Validator::validate);
        System.out.println("working...");
    }
}
