package proxy;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        HelloService service = getService();


        service.sayHello();
        service.bye();
    }

    private static HelloService getService() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            ProxyFactory factory = createProsxyFactory();

            return(HelloService) factory.create(new Class []{}, new Object []{}, createMethdoHandler());

    }

    private static ProxyFactory createProsxyFactory(){
        ProxyFactory factory = new ProxyFactory();

        factory.setFilter(new MethodFilter() {
            @Override
            public boolean isHandled(Method method) {
                return method.isAnnotationPresent(Log.class);
            }
        });
        factory.setSuperclass(HelloService.class);

        return factory;
    }

    private static MethodHandler createMethdoHandler(){
        return new MethodHandler() {
            @Override
            public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
              Log log =  method.getDeclaredAnnotation(Log.class);

                System.out.println(log.value());

                return method1.invoke(o, objects);
            }
        };
    }

}
