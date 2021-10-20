package com.ing.interview.controller.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InsuredValidator.class)
@Documented
public @interface CheckInsured {

	String message() default "El candidato no es elegible para el seguro debido a la edad";

	Class<?>[] groups() default {};

	Class<Payload>[] payload() default {};

}
