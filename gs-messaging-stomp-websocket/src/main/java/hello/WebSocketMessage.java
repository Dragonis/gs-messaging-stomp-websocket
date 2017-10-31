package hello;

public class WebSocketMessage {

    private String content;

    public WebSocketMessage() {
    }

    public WebSocketMessage(String content) {
        this.content = content;
    }

    public String getName() {
        return content;
    }

    public void setName(String content) {
        this.content = content;
    }
}
