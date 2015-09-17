package com.berk.java8examples;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created by berk on 9/16/15.
 */
public class DataTimeDemo
{

    private final String DATE_PATTERN = "[yyyy-MM/dd:HH";

    private final String DATE_TIME_STR_INPUT = "[2015-12/23:13";


    @Test
    public void parseDateTimeStrNew()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDate t1 = LocalDate.parse(DATE_TIME_STR_INPUT, formatter);

        System.out.println("berk" + t1);

    }

    @Test
    public void parseDateTimeStrOld() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        Date datetime = null;
        datetime = sdf.parse(DATE_TIME_STR_INPUT);
        System.out.println("Output:");
        System.out.println(datetime);
    }


    @Test
    public void createDateNew()
    {
        LocalTime time = LocalTime.of(18, 40, 32);
        LocalDate date = LocalDate.of(2015, Month.SEPTEMBER, 18);

        LocalDateTime datetime = LocalDateTime.of(2015, 9, 18, 18, 40, 32);

        System.out.println(time);
        System.out.println(date);
        System.out.println(datetime);

    }

    @Test
    public void createDateOld()
    {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.set(2015, 9, 18, 18, 40, 32);
        Date date = calendar.getTime();

    }


    public static void main(String[] args)
    {
        Stream.of(DataTimeDemo.class.getMethods())
                .filter((x) -> x.getAnnotation(Test.class) != null)
                .filter((x) -> x.getAnnotation(Ignore.class) == null)
                .forEach(System.out::println);
    }
}
