package com.cognyte.covid19.cognytecovid19.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnProdCondition implements Condition {

    private static Boolean answer; // optional : cache the result if we need to

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        //Boolean answer = null;
        if(answer == null) {
            // TODO : create your own code to check your production environment
            answer = true;
        }
        return answer;
    }
}
