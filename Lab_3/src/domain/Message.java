package Lab_3.src.domain;

public class Message {
    private final String content;
    private final String category;

    public Message(String content, String category) {
        this.content = content;
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }
}
