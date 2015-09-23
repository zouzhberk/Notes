package com.berk.java8examples;

import com.berk.java8examples.tester.Test;
import com.berk.java8examples.tester.Tester;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by berk on 9/21/15.
 */
public class UsingResourceDemo extends Tester {

    @Test
    public void testStrings() {
        final String str = "hello world !";


        //Old way, skip 6, limit 5 chars
        int i = 0;
        for (char c : str.toCharArray()) {
            if (i >= 6 && i < 6 + 5) {
                System.out.println(c);
            }
            i++;
        }

        System.out.println("New way");
        //New way
        str.chars().skip(6).limit(5).forEach((x) -> System.out.println((char) x));

    }

    @Test
    public void testDirectory() throws IOException {


        Files.list(Paths.get(".").toAbsolutePath()).filter(Files::isRegularFile).forEach(System.out::println);
    }

    @Test
    public void testDirectory2() throws IOException {
        Files.newDirectoryStream(Paths.get("."), "src").forEach(System.out::println);

        System.out.println("New way 1");

        Files.walk(Paths.get("."), 10).filter((x) -> x.endsWith("java")).forEach(System.out::println);

        System.out.println("New way 11");

        //Files.walk(Paths.get("."), 10, FileVisitOption.FOLLOW_LINKS).filter((x) -> x.endsWith(".java")).forEach(System.out::println);

        System.out.println("New way 2");

        List<File> files =
                Stream.of(new File(".").listFiles())
                        .flatMap(file -> file.listFiles() == null ?
                                Stream.of(file) : Stream.of(file.listFiles()))
                        .collect(toList());
        System.out.println("Count: " + files);


    }

    @Test
    public void testFiles() throws IOException {

        Map<String, Long> map = Files.lines(Paths.get("./build.gradle")).flatMap(line -> line.chars()
                .mapToObj(c -> String.valueOf((char) c)))
                .collect(Collectors.groupingBy((x) -> x, TreeMap::new, Collectors.counting()));
        System.out.println(map);
    }


    public static void main(String[] args) {
        new UsingResourceDemo().execute();
    }


    public static void main1(String[] args) throws IOException {
        Function<Character, Character> classifier = (x) -> x;


        Map<Character, Integer> ret = Files.lines(Paths.get("jdk8-and-function-program.md"))
                .flatMap((x) -> x.chars().mapToObj((c) -> (char) c))
                .collect(Collectors.groupingBy(Character::new, Collectors.summingInt((x) -> 1)));

        List<Map.Entry<Character, Integer>> bb = ret.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))

                .collect(toList());

        System.out.println(ret);
        System.out.println(bb);
    }


    private static Stream<String> regexToList(String words, String regex) {
        Matcher m = Pattern.compile(regex).matcher(words);

        return Stream.iterate(1, f -> f + 1).limit(m.groupCount()).map((i) -> m.group(i));


    }
}
