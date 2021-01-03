package main2;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD}) // specific pe ce element de limbaj pot pune adnotarea
public @interface MyAnnotation {
    String value();

    int other() default  0;


    double [] array() default {};

    // primitive, String, Class<?> -> in adnotari




}
