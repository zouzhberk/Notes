package com.berk.java8examples;

import com.berk.java8examples.tester.Test;
import com.berk.java8examples.tester.Tester;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by berk on 9/21/15.
 */
public class LambdaDemo extends Tester
{

    @Test
    public void testLambda1()
    {

        Consumer<String> consumer1 = new Consumer<String>()
        {
            public void accept(final String name)
            {
                System.out.println(name);
            }
        };

        Consumer<String> consumer2 = (final String name) -> System.out
                .println(name);

        Consumer<String> consumer3 = (name) -> System.out.println(name);

        Consumer<String> consumer4 = name -> System.out.println(name);

        Consumer<String> consumer5 = System.out::println;

        Stream.of("hello", "world").forEach(consumer1);
        Stream.of("hello", "world").forEach(consumer2);
        Stream.of("hello", "world").forEach(consumer3);
        Stream.of("hello", "world").forEach(consumer4);
        Stream.of("hello", "world").forEach(consumer5);
    }


    @Test
    public void testMethodReference()
    {
        final List<Integer> words = IntStream.range('A', 'z')
                .mapToObj(Integer::new)
                .collect(Collectors.toList());

        BigDecimal bigDecimal = Stream.of("hello", "world", "!")
                .flatMapToInt((s) -> s.chars())
                .filter((s) -> words.contains(s))
                .mapToObj((s) -> String.valueOf(s))
                .map((s) -> new BigDecimal(s))
                .reduce(new BigDecimal(1), (x, y) -> x.add(y));


        System.out.println(bigDecimal);


        BigDecimal ret = Stream.of("hello", "world", "!")

                .flatMapToInt(String::chars)
                .filter(words::contains)
                .mapToObj(String::valueOf)
                .map(BigDecimal::new)
                .reduce(new BigDecimal(1), BigDecimal::add);

        System.out.println(ret);
    }

    public static void main(String[] args)
    {
        new LambdaDemo().execute();
    }

}
