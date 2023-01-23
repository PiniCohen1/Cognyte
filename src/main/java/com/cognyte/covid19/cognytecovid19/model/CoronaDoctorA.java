package com.cognyte.covid19.cognytecovid19.model;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CoronaDoctorA implements CoronaDoctor {


    @Override
    public void treatCurrentMutation() {
        // Here you will right your logic
        System.out.println("Doctor treat Mutation A");
    }
}
