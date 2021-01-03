package lib.dto;

public class MessageEvent extends Event {

    private String Message;


    public MessageEvent(String user, String message) {
        super(user);
        Message = message;
    }

    public String getMessage() {
        return Message;
    }




}
