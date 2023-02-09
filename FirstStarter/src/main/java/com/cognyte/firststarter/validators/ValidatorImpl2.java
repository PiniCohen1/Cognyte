package com.cognyte.firststarter.validators;

import com.cognyte.firststarter.exception.CognyteException;
import org.springframework.stereotype.Component;

@Component
public class ValidatorImpl2 implements Validator {
    @Override
    public void validate() {

        // System.out.println("Validator 2 say that its OK");
        throw new CognyteException("problem");
    }
}
