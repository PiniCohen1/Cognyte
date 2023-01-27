package com.cognyte.covid19.cognytecovid19.model;

import com.cognyte.covid19.cognytecovid19.condition.ConditionOnEmergency;
import static com.cognyte.covid19.cognytecovid19.condition.ConditionOnEmergency.Priority;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
@ConditionOnEmergency(priority = Priority.Emergency)
public class CoronaDoctorB implements CoronaDoctor {
    @Override
    public void treatCurrentMutation() {
        System.out.println("Doctor treat Mutation B");
    }
}
