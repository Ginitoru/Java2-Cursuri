package service.impl;

import service.FisierService;
import service.FolderService;

import java.util.HashMap;
import java.util.Map;

public class ServiceProvider {

    private Map<Class, Object> registry = new HashMap<>();

    public ServiceProvider() {
        registry.put(FolderService.class, new FolderServiceImpl());
        registry.put(FisierService.class, new FisierServiceImpl());

    }

    private static final class SingletonHolder{
        public static final ServiceProvider INSTACE = new ServiceProvider();
    }

    public static ServiceProvider getInstance(){
        return SingletonHolder.INSTACE;

    }


    public <T> T get(Class<T> clasa){
        Object service  = registry.get(clasa);

        return clasa.cast(service);
    }


}
