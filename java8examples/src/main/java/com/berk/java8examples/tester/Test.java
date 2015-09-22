package com.berk.java8examples.tester;

import java.lang.annotation.*;

/**
 * Created by berk on 9/17/15.
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(Tests.class)
public @interface Test
{
    public static final String NONE = "NONE";

    String desc() default "";

    Class<? extends Throwable> expected() default Throwable.class;

    String[] value() default Test.NONE;
}
