package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex1 {
    public static void main(String[] args) {

        try {
            Class<Punct> punctClass = (Class<Punct>) Class.forName("main.Punct");

             Constructor<Punct> constructor = punctClass.getDeclaredConstructor();
             constructor.setAccessible(true);

             Punct punct = constructor.newInstance();

            Field xField =  punctClass.getDeclaredField("x");

            xField.setAccessible(true);
            Valoare vx = xField.getDeclaredAnnotation(Valoare.class);
            xField.setInt(punct , vx.value());

            Field yFiled = punctClass.getDeclaredField("y");

            yFiled.setAccessible(true);
            Valoare vy = yFiled.getDeclaredAnnotation(Valoare.class);
            yFiled.setInt(punct, vy.value());

            Method afisMtehod = punctClass.getDeclaredMethod("afis");
            afisMtehod.setAccessible(true);
            afisMtehod.invoke(punct);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
