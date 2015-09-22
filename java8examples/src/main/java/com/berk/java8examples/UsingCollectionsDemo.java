package com.berk.java8examples;

import com.berk.java8examples.tester.Ignore;
import com.berk.java8examples.tester.Test;
import com.berk.java8examples.tester.Tester;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by berk on 9/21/15.
 */
public class UsingCollectionsDemo extends Tester
{

    @Test
    public void testIteratingList()
    {
        final List<String> friends = Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

        //OLD Style 1
        for (int i = 0; i < friends.size(); i++)
        {
            System.out.println(friends.get(i));
        }

        //OLD Style 2
        for (String friend : friends)
        {
            System.out.println(friend);
        }

        //New Style 1
        friends.forEach(new Consumer<String>()
        {
            public void accept(final String name)
            {
                System.out.println(name);
            }
        });

        //New Style 2, with lambda expression.
        friends.forEach((friend) -> System.out.println(friend));
        friends.forEach(friend -> System.out.println(friend));

        //New Style 3, With method reference

        friends.forEach(System.out::println);

    }




    public void testNewStream()
    {
        String regex = "\\w+";


        Matcher m = Pattern.compile(regex).matcher(UsingCollectionsDemo.TEST_STR);

        Spliterator<String[]> spliter = new PatternSpliterator(m);
        StreamSupport.stream(spliter, false);

    }


    private final static String TEST_STR = "import java util regex Matcher;\n" +
            "import java util regex Pattern ;\n" +
            "import java.util.stream.Stream;";

    private final static List<String> NON_WORDS = Arrays.asList("the", "and", "of", "to", "be", "util");


    private static Stream<String> regexToListUsingStream(String words, String regex)
    {
        Matcher m = Pattern.compile(regex).matcher(words);

        Spliterator<String[]> spliter = new PatternSpliterator(m);
        return StreamSupport.stream(spliter, false).flatMap(Stream::of);

    }


    private static Stream<String> regexToListOLD(String words, String regex)
    {
        Matcher m = Pattern.compile(regex).matcher(words);

        List<String> list = new ArrayList<>();

        while (m.find())
        {
            list.add(m.group());
        }
        return list.stream();


    }

    @Test
    @Ignore
    public void testStringPattern()
    {
        String regex = "\\w+";

        regexToListUsingStream(UsingCollectionsDemo.TEST_STR, regex).limit(20).forEach(System.out::println);


        Map<String, Integer> map = regexToListOLD(UsingCollectionsDemo.TEST_STR, "\\w+").map(w -> w.toLowerCase())
                .peek(System.out::println)
                .filter(w -> !NON_WORDS.contains(w))
                .collect(groupingBy(String::new, summingInt(x -> 1)));

        System.out.println(map);

    }

    public static void main(String[] args)
    {
        new UsingCollectionsDemo().execute();
    }


    private static class PatternSpliterator extends Spliterators.AbstractSpliterator<String[]>
    {
        private final Matcher matcher;

        /**
         * Creates a spliterator reporting the given estimated size and
         * additionalCharacteristics.
         *
         * @param m
         */
        protected PatternSpliterator(Matcher m)
        {
            super(Long.MAX_VALUE, Spliterator.ORDERED | NONNULL | IMMUTABLE);
            this.matcher = m;
        }

        @Override
        public boolean tryAdvance(Consumer<? super String[]> action)
        {
            if (!matcher.find())
            {
                return false;
            }

            action.accept(Stream.iterate(0, f -> f + 1)
                    .limit(matcher.groupCount() + 1)
                    .map(matcher::group)
                    .toArray(String[]::new));

            return true;
        }
    }
}
