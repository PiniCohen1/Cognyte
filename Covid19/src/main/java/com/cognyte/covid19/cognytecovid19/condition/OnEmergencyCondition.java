package com.cognyte.covid19.cognytecovid19.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import static com.cognyte.covid19.cognytecovid19.condition.ConditionOnEmergency.Priority;
import java.util.Map;
import java.util.Objects;

public class OnEmergencyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        // Get the Priority definition of specific bean
        Map<String, Object> attributes = metadata.getAnnotationAttributes(
                ConditionOnEmergency.class.getName());
        Priority priority = (Priority) Objects.requireNonNull(
                attributes).get("priority");

        // True only on critical
        return priority.getValue() <= Priority.Emergency.getValue();
    }
}
