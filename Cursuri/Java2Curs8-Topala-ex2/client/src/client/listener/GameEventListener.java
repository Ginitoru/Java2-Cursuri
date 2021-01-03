package client.listener;

import lib.event.GameEvent;

public interface GameEventListener<EV extends GameEvent>{

    boolean isAplicable(Class<?> eventClass);

    void accept(EV event);


}
