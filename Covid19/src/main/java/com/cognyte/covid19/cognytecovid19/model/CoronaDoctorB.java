package com.cognyte.covid19.cognytecovid19.model;

import com.cognyte.covid19.cognytecovid19.condition.ConditionOnProd;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@ConditionOnProd
public class CoronaDoctorB implements CoronaDoctor {
    @Override
    public void treatCurrentMutation() {
        System.out.println("Doctor treat Mutation B");
    }
}
