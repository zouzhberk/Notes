package com.berk.java8examples;

/**
 * Created by berk on 9/22/15.
 */
@FunctionalInterface
public interface MyConsumer<T>
{
    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     */
    void accept(T t);

}
