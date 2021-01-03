package client.controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class EventController {

    private final ScheduledExecutorService service;

    private final Map<String, List<EventListener>> listeners = new ConcurrentHashMap<>();



    private EventController() {
        service = Executors.newSingleThreadScheduledExecutor();
//        var task = (Runnable) () -> {
//
//            var unseenEvents = MessageController.getInstance().getEvents(user);
//                if(!unseenEvents.isEmpty()){
//
//                }
//
//        };

  //      service.scheduleWithFixedDelay(task, 0,3, TimeUnit.SECONDS);
    }

    private static final class SingletonHoilder{
        public static final EventController INSTANCE = new EventController();
    }


    public static EventController getInstance(){
        return SingletonHoilder.INSTANCE;
    }

    public void listenForEvents(String user) {
        var task = (Runnable) () -> {
            var unseenEvents = MessageController.getInstance().getEvents(user);
            if (!unseenEvents.isEmpty()) {

                listeners.get(user).forEach(listener ->
                        unseenEvents.forEach(listener:: newEvent));

            }
        };
        service.scheduleWithFixedDelay(task, 0, 3, TimeUnit.SECONDS);
    }


    public void addListener(String user, EventListener listener){
        listeners.computeIfAbsent(user, x -> new CopyOnWriteArrayList<>())
                .add(listener);
    }

    public void removeListeners (String user, EventListener listener){
        if(listeners.containsKey(user)){
            listeners.get(user).remove(listener);
        }
    }








}
