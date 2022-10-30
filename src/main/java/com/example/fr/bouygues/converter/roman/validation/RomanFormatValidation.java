package com.example.fr.bouygues.converter.roman.validation;

import lombok.NonNull;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RomanFormatValidator.class)
@Documented
@NonNull
public @interface RomanFormatValidation {

    String message() default "Bad format for a roman number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
