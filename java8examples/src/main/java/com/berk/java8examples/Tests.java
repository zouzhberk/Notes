package com.berk.java8examples;

import java.lang.annotation.*;

/**
 * Created by berk on 9/17/15.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Tests  {
    Test[]  value();
}
