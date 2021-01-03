package client.listener;

import client.service.GameController;
import lib.event.GameEvent;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class DispecerService {



    private ScheduledExecutorService executorService;

    private String gameId;

    private static Map<String, DispecerService> registry = new ConcurrentHashMap<>();

    private List<GameEventListener> listeners = new CopyOnWriteArrayList<>();

    private DispecerService(String gameId){
        this.gameId = gameId;
        executorService = Executors.newSingleThreadScheduledExecutor();

        executorService.scheduleWithFixedDelay(
                () -> GameController.getInstance().getEvents(gameId)
                        .forEach(this::notifyListeners),0,1, TimeUnit.SECONDS



        );
    }

    public static DispecerService getInstance(String gameId){
        registry.putIfAbsent(gameId, new DispecerService(gameId));

        return registry.get(gameId);
    }



    public void addListener(GameEventListener listener){
        listeners.add(listener);
    }

    public void removeListener(GameEventListener listener){
        listeners.remove(listener);
    }

    public void notifyListeners(GameEvent event){
        listeners.stream()
                .filter(listener -> listener.isAplicable(event.getClass()))
                .forEach(listener -> listener.accept(event));
    }
}
