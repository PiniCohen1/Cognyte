package com.cognyte.covid19.cognytecovid19.model;

import com.cognyte.covid19.cognytecovid19.condition.ConditionOnEmergency;
import static com.cognyte.covid19.cognytecovid19.condition.ConditionOnEmergency.Priority;
import lombok.Getter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
@ConditionOnEmergency(priority = Priority.Critical)
public class CoronaDoctorOximiron implements CoronaDoctor {

    @Getter
    private final String treatMessage="Doctor treat Mutation Oximiron";

    @Override
    public void treatCurrentMutation() {
        System.out.println(treatMessage);
    }
}
