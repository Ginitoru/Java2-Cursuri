package pachet1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws Exception {
       Class punctClass = Class.forName("pachet1.Punct");

        Constructor punctConstructor = punctClass.getDeclaredConstructor();

        Punct p1 = (Punct) punctConstructor.newInstance();
        Field xFiled = punctClass.getDeclaredField("x");
        xFiled.setAccessible(true);
        xFiled.setInt(p1, 10);
        System.out.println(xFiled.get(p1));
        System.out.println(p1);






    }
}
