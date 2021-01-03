package client.listener;

import lib.event.AnswerEvent;

public interface AnswerEventListener extends GameEventListener<AnswerEvent>{
    @Override
    default boolean isAplicable(Class<?> eventClass) {
        return AnswerEvent.class.equals(eventClass);
    }
}
