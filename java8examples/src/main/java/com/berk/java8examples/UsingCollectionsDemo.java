package com.berk.java8examples;

import com.berk.java8examples.tester.Ignore;
import com.berk.java8examples.tester.Test;
import com.berk.java8examples.tester.Tester;

import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

/**
 * Created by berk on 9/21/15.
 */
public class UsingCollectionsDemo extends Tester {

    private final static String TEST_STR =
            "import java util regex Matcher;\n" +
                    "import java util regex Pattern ;\n" +
                    "import java.util.stream.Stream;";
    private final static List<String> NON_WORDS =
            Arrays.asList("the", "and", "of", "to", "be", "util");

    private static Stream<String> regexToListUsingStream(String words, String regex) {
        Matcher m = Pattern.compile(regex).matcher(words);

        Spliterator<String[]> spliter = new PatternSpliterator(m);
        return StreamSupport.stream(spliter, false).flatMap(Stream::of);

    }

    private static Stream<String> regexToListOLD(String words, String regex) {
        Matcher m = Pattern.compile(regex).matcher(words);

        List<String> list = new ArrayList<>();

        while (m.find()) {
            list.add(m.group());
        }
        return list.stream();


    }

    public static void main(String[] args) {
        new UsingCollectionsDemo().execute();
    }

    @Test
    @Ignore
    public void testIteratingList() {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara",
                        "Scott");

        //OLD Style 1
        for (int i = 0; i < friends.size(); i++) {
            System.out.println(friends.get(i));
        }

        //OLD Style 2
        for (String friend : friends) {
            System.out.println(friend);
        }

        //New Style 1
        friends.forEach(new Consumer<String>() {
            public void accept(final String name) {
                System.out.println(name);
            }
        });

        //New Style 2, with lambda expression.
        friends.forEach((friend) -> System.out.println(friend));
        friends.forEach(friend -> System.out.println(friend));

        //New Style 3, With method reference

        friends.forEach(System.out::println);

    }

    @Test
    public void testMap() {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara",
                        "Scott");

        //Old way.
        List<String> uppercaseNames = new ArrayList<String>();
        for (String name : friends) {
            uppercaseNames.add(name.toUpperCase());
        }
        System.out.println(uppercaseNames);

        //New way.
        uppercaseNames = friends.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(uppercaseNames);
    }

    @Test
    public void testFilter() {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara",
                        "Scott");

        //Old way.
        for (String name : friends) {
            if (name.contains("r") && name.contains("a")) {
                System.out.println(name);
            }
        }
        //New way.
        friends.stream().filter((s) -> s.contains("r"))
                .filter((s) -> s.contains("a"))
                .forEach(System.out::println);
    }

    @Test
    @Ignore
    public void testPickElement() {
        final List<String> friends =
                Arrays.asList("Brian", "Nate", "Neal", "Raju", "Sara",
                        "Scott");

        //Old way
        String foundName = null;
        for (String name : friends) {
            if (name.startsWith("N")) {
                foundName = name;
                break;
            }
        }
        if (foundName == null) {
            throw new NoSuchElementException("no name found.");
        }
        System.out.println(foundName);

        //New way.
        friends.stream().filter((s) -> s.startsWith("N")).findFirst()
                .ifPresent(System.out::println);

    }

    @Ignore
    @Test
    public void testReduce1() {
        final List<Person> friends =
                Arrays.asList(new Person("Brian", 20), new Person
                        ("Nate", 28), new Person("Neal", 40), new Person
                        ("Raju", 35), new Person("Sara", 30), new Person
                        ("Scot", 22));


        //Old way

        // Max age
        friends.stream().max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        friends.stream().collect(Collectors
                .maxBy(Comparator.comparing(Person::getAge)))
                .ifPresent(System.out::println);

        friends.stream()
                .reduce((x, y) -> x.getAge() - y.getAge() > 0 ? x : y)
                .ifPresent(System.out::println);

        //total age.
        Integer ret = friends.stream().collect(Collectors
                .summingInt(Person::getAge));
        Optional<Integer> ret1 = friends.stream().map(Person::getAge)
                .reduce((x, y) -> x + y);
        ret1.filter((x) -> x == ret).ifPresent(System.out::println);

        //Average age.
        friends.stream().collect(Collectors.averagingInt(Person::getAge));

        //age statistics. including count, sum, min, average and max
        // values.
        IntSummaryStatistics ret3 = friends.stream().collect(Collectors
                .summarizingInt(Person::getAge));
        System.out.println(ret3);
    }


    @Test
    public void testReduce2() {
        final List<Person> friends =
                Arrays.asList(new Person("Brian", 20), new Person
                        ("Nate", 28), new Person("Neal", 40), new Person
                        ("Raju", 35), new Person("Sara", 30), new Person
                        ("Scot", 22), new Person("Raju", 35), new Person
                        ("Raju", 24));


        //to Map
        //        friends.stream().collect(Collectors.mapping((x) -> x
        // .getName(), ));
        friends.stream().collect(Collectors
                .toMap(Person::getName, Person::getAge, (x, y) -> x))
                .forEach((x, y) -> System.out.println(x + ", " + y));

        System.out.println();
        //to Map, order by key.
        friends.stream().collect(Collectors
                .toMap(Person::getName, Person::getAge, (x, y) -> y,
                        TreeMap::new))
                .forEach((x, y) -> System.out.println(x + ", " + y));


        //toMap, group by name
        friends.stream().collect(Collectors
                .groupingBy(Person::getName, Collectors
                        .mapping(Person::getAge, Collectors.toList())))
                .forEach((x, y) -> System.out.println(x + ", " + y));
        friends.stream().collect(Collectors
                .groupingBy(Person::getName, Collectors
                        .summingInt(Person::getAge)))
                .forEach((x, y) -> System.out.println(x + ", " + y));

        friends.stream().collect(Collectors
                .groupingBy(Person::getName, Collectors.counting()))
                .forEach((x, y) -> System.out.println(x + ", " + y));

        // toMap ,partitioningBy
        friends.stream().collect(Collectors.partitioningBy((x) -> x.getAge() > 30, Collectors.toList())).forEach((x, y) -> System.out.println(x + ", " + y));

        friends.stream().collect(Collectors.partitioningBy((x) -> x.getAge() > 30, Collectors.toMap(Person::getName, Person::getAge, (x, y) -> y,
                TreeMap::new))).forEach((x, y) -> System.out.println(x + ", " + y));
        friends.stream().parallel().sequential().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.partitioningBy((x) -> x.getAge() > 30, Collectors
                .mapping(Person::getAge, Collectors.toList()))).forEach((x, y) -> System.out.println(x + ", " + y));


        Stream.generate(() ->
        {
            return String.valueOf(new Random().nextInt());

        }).limit(10).forEach(System.out::println);

    }

    public void testNewStream() {

        String regex = "\\w+";


        Matcher m = Pattern.compile(regex)
                .matcher(UsingCollectionsDemo.TEST_STR);

        Spliterator<String[]> spliter = new PatternSpliterator(m);
            StreamSupport.stream(spliter, false);

    }

    @Test
    public void testStringPattern() {
        String regex = "\\w+";

        regexToListUsingStream(UsingCollectionsDemo.TEST_STR, regex)
                .limit(20).forEach(System.out::println);


        Map<String, Integer> map =
                regexToListOLD(UsingCollectionsDemo.TEST_STR, "\\w+")
                        .map(w -> w.toLowerCase())
                        .peek(System.out::println)
                        .filter(w -> !NON_WORDS.contains(w))
                        .collect(groupingBy(String::new, summingInt(x ->
                                1)));

        System.out.println(map);

    }

    public static class Person {
        private final String name;
        private final int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getNameOptional() {
            return Optional.ofNullable(name);
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    private static class PatternSpliterator extends Spliterators
            .AbstractSpliterator<String[]> {
        private final Matcher matcher;

        /**
         * Creates a spliterator reporting the given estimated size and
         * additionalCharacteristics.
         *
         * @param m
         */
        protected PatternSpliterator(Matcher m) {
            super(Long.MAX_VALUE,
                    Spliterator.ORDERED | NONNULL | IMMUTABLE);
            this.matcher = m;
        }

        @Override
        public boolean tryAdvance(Consumer<? super String[]> action) {
            if (!matcher.find()) {
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
