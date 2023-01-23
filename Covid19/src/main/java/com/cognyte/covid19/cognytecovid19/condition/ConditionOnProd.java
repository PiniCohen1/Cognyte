package com.cognyte.covid19.cognytecovid19.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Conditional(OnProdCondition.class)
public @interface ConditionOnProd {
}
