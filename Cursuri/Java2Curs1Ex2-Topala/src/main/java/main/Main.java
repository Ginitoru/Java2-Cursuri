package main;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        var helloService = getService();

        helloService.sayHello();
        helloService.sayBye();


    }

    public static HelloService getService() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        ProxyFactory factory = new ProxyFactory();

        //setam drept clasa mostenita a proxiului clasa HelloService
        //pentru aputea pun eprin polimirfism instanta de HelloService
        factory.setSuperclass(HelloService.class);

        factory.setFilter(new MethodFilter() {
            @Override
            public boolean isHandled(Method method) {
                return method.isAnnotationPresent(Logged.class);
            }
        });

        MethodHandler handler = new MethodHandler() {
            @Override
            public Object invoke(Object self, Method thisMethod, Method proceed, Object[] objects) throws Throwable {
                System.out.println("a fost apelata" + thisMethod);

                //apelam metoda originala
                Object result = proceed.invoke(self, objects);
                return null;
            }
        };
        return (HelloService) factory.create(new Class<?> []{}, new Object[]{}, handler);
    }

}
