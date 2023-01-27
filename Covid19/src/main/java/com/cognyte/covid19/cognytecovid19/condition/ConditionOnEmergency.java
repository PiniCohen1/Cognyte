package com.cognyte.covid19.cognytecovid19.condition;

import lombok.Getter;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(OnEmergencyCondition.class)
public @interface ConditionOnEmergency {

    Priority priority();

    enum Priority {
        Critical(1), Emergency(2), Regualr(3);

        @Getter
        private final int value;

        Priority(int value) {
            this.value = value;
        }
    }
}
