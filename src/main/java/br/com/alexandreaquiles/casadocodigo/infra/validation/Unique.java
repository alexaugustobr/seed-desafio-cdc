package br.com.alexandreaquiles.casadocodigo.infra.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = UniquenessValidator.class)
@Target(FIELD)
@Retention(RUNTIME)
public @interface Unique {

    String message() default "{br.com.alexandreaquiles.casadocodigo.infra.validation.Unique.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> entity();
    String field();
}
