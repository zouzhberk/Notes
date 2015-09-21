package com.berk.java8examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by berk on 9/21/15.
 */
public class UsingCollectionsDemo
{

    private final static String TEST_STR = "import java util regex Matcher;\n" +
            "import java util regex Pattern ;\n" +
            "import java.util.stream.Stream;";

    private final static List<String> NON_WORDS = Arrays.asList("the", "and", "of", "to", "be", "util");

    private static Stream<String> regexToList(String words, String regex)
    {
        Matcher m = Pattern.compile(regex).matcher(words);

        List<String> list = new ArrayList<>();

        while (m.find())
        {
            System.out.println(m.group());
            list.add(m.group());
        }

        Stream.iterate(m.find()0, f -> f + 1).limit(m.groupCount()).map((i) -> m.group(i));
        return list.stream();


    }


    public static void main(String[] args)
    {
        regexToList(UsingCollectionsDemo.TEST_STR, "\\w+").forEach(System.out::println);
        Map<String, Integer> map = regexToList(UsingCollectionsDemo.TEST_STR, "\\w+").map(w -> w.toLowerCase())
                .peek(System.out::println)
                .filter(w -> !NON_WORDS.contains(w))
                .collect(Collectors.groupingBy(String::new, Collectors.summingInt(x -> 1)));

        System.out.println(map);
    }
}
