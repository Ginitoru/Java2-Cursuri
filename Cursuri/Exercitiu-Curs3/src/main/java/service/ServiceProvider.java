package service;

import service.impl.ZborServiceImpl;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {

    private Map<Class, Object> registry = new HashMap<>();

    public ServiceProvider() {
        registry.put(ZborService.class, new ZborServiceImpl());
    }

    private static final class SingletonHolder{
        public static final ServiceProvider INSTANCE = new ServiceProvider();
    }

    public static final ServiceProvider getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public <T> T get(Class<T> clasa){
        Object service = registry.get(clasa);

        return clasa.cast(service);
    }


}
