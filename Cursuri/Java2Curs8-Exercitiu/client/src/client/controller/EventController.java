package client.controller;

import lib.dto.Event;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class EventController {

    private final ScheduledExecutorService service;

    private final Map<String, List<EventListener>> listeners = new ConcurrentHashMap<>();


    public EventController() {

        service  = Executors.newSingleThreadScheduledExecutor();

    }


    public void listenForEvents(String user){


        Runnable task = () ->{

            List<Event> unseenEvents = MessageController.getInstance().getEvents(user);

            if(!unseenEvents.isEmpty()){

                listeners.get(user).forEach(
                        listener -> {
                            for (Event unseenEvent : unseenEvents) {
                                listener.newEvent(unseenEvent);
                            }
                        }
                );
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


    private static final class SingletonHolder{
        public static EventController INSTANCE = new EventController();
    }

    public static EventController getInstance(){
        return SingletonHolder.INSTANCE;
    }


}
