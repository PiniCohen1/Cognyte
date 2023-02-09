package com.cognyte.firststarter.validators;

import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl1 implements Validator {
    @Override
    public void validate() {
        System.out.println("Validator 1 say that its OK");
    }
}
