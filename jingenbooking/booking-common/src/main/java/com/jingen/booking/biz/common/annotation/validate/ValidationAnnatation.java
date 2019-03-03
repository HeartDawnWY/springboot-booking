package com.jingen.booking.biz.common.annotation.validate;

import com.jingen.booking.biz.common.validate.ValidationMethodEnum;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ValidationAnnotations.class)
public @interface ValidationAnnatation {
    ValidationMethodEnum methodName();
    int maxLen() default 100;
    int minLen() default 1;
    String message();
    String pattern() default "";
}
