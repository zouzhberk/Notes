package com.berk.java8examples.tester;

import com.berk.java8examples.DataTimeDemo;
import com.berk.java8examples.LambdaDemo;
import com.berk.java8examples.UsingCollectionsDemo;
import com.berk.java8examples.UsingResourceDemo;
import com.google.gson.Gson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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

    public static Boolean invoke(Class<?> clazz, Method method, String[] jsons)
    {
        if (jsons == null || jsons.length == 0 || Stream.of(jsons).anyMatch(x -> x.equals(Test.NONE)))
        {
            return invoke(clazz, method);
        }

        Class[] paramTypes = Stream.of(method.getParameters()).map(x -> x.getType()).toArray(Class[]::new);

        Parameter[] params = method.getParameters();

        return invoke(clazz, method, Stream.iterate(0, e -> e + 1)
                .limit(method.getParameterCount())
                .sequential()
                .map(i -> {
                    return Stream.of(jsons)
                            .skip(i)
                            .findFirst()
                            .map(json -> fromJson(json, params[i].getType()))
                            .orElse(null);
                })
                .toArray());

    }


    public static <T> T fromJson(String json, Class<T> type)
    {
        return type.equals(String.class) ? type.cast(json) : new Gson().fromJson(json, type);
    }

    public static class MethodExecutor
    {
    }

    public static void main(String[] args) throws Exception
    {
        if (new Tester().execute())
        {
            return;
        }

        Stream.of(LambdaDemo.class, UsingCollectionsDemo.class, UsingResourceDemo.class, DataTimeDemo.class)
                .filter((x) -> x.getAnnotation(Ignore.class) != null)
                .forEach(Tester::execute);

    }

    public static void executeMethod(Class<?> clazz, Method method)
    {
        Stream.of(method.getAnnotationsByType(Test.class)).forEach(x -> {
            invoke(clazz, method, x.value());
        });

    }

    public boolean execute()
    {
        if (!this.getClass().equals(Tester.class))
        {
            execute(this.getClass());
            return true;
        }

        return false;
    }


    public static void execute(Class<?> clazz)
    {

        Stream.of(clazz.getMethods())
                .filter((x) -> x.getAnnotation(Test.class) != null)
                .filter((x) -> x.getAnnotation(Ignore.class) == null)
                .forEach(x -> invoke(clazz, x));


    }

}
