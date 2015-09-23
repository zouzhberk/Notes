package com.berk.java8examples.tester;

import java.lang.annotation.*;

/**
 * Created by berk on 9/17/15.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface Ignore {
}
