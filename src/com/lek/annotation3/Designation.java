package com.lek.annotation3;

import java.lang.annotation.*;

@Repeatable(value = Designations.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Designation {
    String value() default "Employee";
}
