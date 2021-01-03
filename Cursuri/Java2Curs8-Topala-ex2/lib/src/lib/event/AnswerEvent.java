package lib.event;

import lib.model.Answer;
import lib.model.Player;

public class AnswerEvent implements GameEvent {

    private final String id;

    private final Player player;

    private final Answer answer;

    public AnswerEvent(String id, Player player, Answer answer) {
        this.id = id;
        this.player = player;
        this.answer = answer;
    }

    public String getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public Answer getAnswer() {
        return answer;
    }
}
