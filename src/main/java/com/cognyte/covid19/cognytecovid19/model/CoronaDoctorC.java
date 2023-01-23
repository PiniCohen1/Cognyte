package com.cognyte.covid19.cognytecovid19.model;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class CoronaDoctorC implements CoronaDoctor {
    @Override
    public void treatCurrentMutation() {
        System.out.println("Doctor treat Mutation C");
    }
}
