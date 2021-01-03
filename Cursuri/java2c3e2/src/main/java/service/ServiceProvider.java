package service;

import service.impl.PisicaServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {

    private Map<Class, Object> registry = new HashMap<>();

    private ServiceProvider() {
        registry.put(PisicaService.class, new PisicaServiceImpl());

    }

    private static final class SingletonHolder{
        public final static ServiceProvider INSTACE = new ServiceProvider();
    }

    public static ServiceProvider getInstance(){
        return SingletonHolder.INSTACE;
    }

    public <T> T get(Class<T> clazz){
        Object service = registry.get(clazz);
        return clazz.cast(service);
    }

}
