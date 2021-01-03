package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex1 {
    public static void main(String[] args) throws Exception {

      Class<Punct> punctClass = (Class<Punct>) Class.forName("main.Punct");

        Constructor<Punct> constructor = punctClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        Punct punct = constructor.newInstance();

        Field xField = punctClass.getDeclaredField("x");
        xField.setAccessible(true);
        xField.setInt(punct, 5);

        Method afisMethod = punctClass.getDeclaredMethod("afis");
        afisMethod.setAccessible(true);

        afisMethod.invoke(punct);


    }
}
