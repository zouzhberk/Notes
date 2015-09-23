package com.berk.java8examples;

import com.berk.java8examples.tester.Test;
import com.berk.java8examples.tester.Tester;

import java.util.Optional;

/**
 * Created by berk on 9/23/15.
 */
public class UsingOptional extends Tester {

    @Test
    public void testOptional() {
        Optional<UsingCollectionsDemo.Person> optional = Optional.of(new UsingCollectionsDemo.Person("aaa", 22));
        optional.map(UsingCollectionsDemo.Person::getName).ifPresent(System.out::println);

        Optional<UsingCollectionsDemo.Person> optional1 = Optional.of(new UsingCollectionsDemo.Person(null, 22));
        System.out.println(optional1.flatMap(UsingCollectionsDemo.Person::getNameOptional).orElse("null"));


    }


    public static void main(String[] args) {
        new UsingOptional().execute();
    }

}
