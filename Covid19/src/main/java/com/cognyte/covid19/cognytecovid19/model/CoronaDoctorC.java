package com.cognyte.covid19.cognytecovid19.model;

import lombok.Getter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class CoronaDoctorC implements CoronaDoctor {

    @Getter
    private String treatMessage="Doctor treat Mutation C";

    @Override
    public void treatCurrentMutation() {
        System.out.println(treatMessage);
    }
}
