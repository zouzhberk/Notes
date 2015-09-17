package com.berk.java8examples;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Created by berk on 9/17/15.
 */
public class Tester
{

    public static Boolean invoke(Class<?> clazz, Method method, Object... args)
    {


        try
        {
            Object object = clazz.newInstance();
            method.invoke(object, args);
            System.out.println("TEST: " + method + ", [SUCCESS]");
            return true;
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
            System.out.println("TEST: " + method + ", [FAILED]");
            return false;

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println("TEST: " + method + ", [FAILED]");
            return false;
        }

    }

    public static void main(String[] args) throws Exception
    {
        new Tester().execute(DataTimeDemo.class);
    }

    public void execute(Class<?> clazz) throws Exception
    {

        Stream.of(clazz.getMethods())
                .filter((x) -> x.getAnnotation(Test.class) != null)
                .filter((x) -> x.getAnnotation(Ignore.class) == null)
                .forEach(x -> invoke(clazz, x));


    }

}
