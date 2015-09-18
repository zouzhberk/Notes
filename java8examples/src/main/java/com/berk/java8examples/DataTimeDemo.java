package com.berk.java8examples;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by berk on 9/16/15.
 */
public class DataTimeDemo
{

    private final static String DATE_PATTERN = "[yyyy-MM/dd:HH";
    private final static String DATE_PATTERN2 = "yyyy-MM/dd:HH";
    private final static String DATE_TIME_STR_INPUT = "[2015-12/23:13";


    @Test(DATE_PATTERN)
    @Test(DATE_PATTERN2)
    public void parseDateTimeStrNew(String pattern, int arg2)
    {


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        TemporalAccessor out1 = formatter.parse(DATE_TIME_STR_INPUT);
        System.out.println(LocalDateTime.from(out1));
        LocalDateTime t1 = LocalDateTime.parse(DATE_TIME_STR_INPUT, formatter);

        System.out.println("berk" + t1);

    }

    @Test
    public void parseDateTimeStrOld() throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        Date datetime = sdf.parse(DATE_TIME_STR_INPUT);
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
    public void nowDateNew()
    {

    }


    @Test
    public void createDateOld()
    {
        Calendar calendar = Calendar.getInstance(Locale.getDefault());
        calendar.set(2015, 9, 18, 18, 40, 32);
        Date date = calendar.getTime();

    }

}
