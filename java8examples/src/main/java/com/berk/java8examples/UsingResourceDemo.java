package com.berk.java8examples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by berk on 9/21/15.
 */
public class UsingResourceDemo
{

    public static void main(String[] args) throws IOException
    {
        Function<Character, Character> classifier = (x) -> x;


        Map<Character, Integer> ret = Files.lines(Paths.get("jdk8-and-function-program.md"))
                .flatMap((x) -> x.chars().mapToObj((c) -> (char) c))
                .collect(Collectors.groupingBy(Character::new, Collectors.summingInt((x) -> 1)));

        List<Map.Entry<Character, Integer>> bb = ret.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))

                .collect(Collectors.toList());

        System.out.println(ret);
        System.out.println(bb);
    }


    private static Stream<String> regexToList(String words, String regex)
    {
        Matcher m = Pattern.compile(regex).matcher(words);

        return Stream.iterate(1, f -> f + 1).limit(m.groupCount()).map((i) -> m.group(i));


    }
}
