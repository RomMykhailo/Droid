package com.example.droid.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyValidator.class)
public @interface MyValidation {
    boolean required() default true;
    String message() default "Doesn't match the pattern";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
