package com.cognyte.aspectsexample.validators;

import com.cognyte.aspectsexample.exception.CognyteException;
import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl2 implements Validator {
    @Override
    public void validate() {

        System.out.println("Validator 2 say that its OK");
        throw new CognyteException("problem");
    }
}
