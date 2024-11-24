package Lab_3.src.domain;

import Lab_3.src.utilities.CommunicationMediator;

public class User {
    private final String name;
    private final UserRole role;
    private final CommunicationMediator mediator;

    public User(String name, UserRole role, CommunicationMediator mediator) {
        this.name = name;
        this.role = role;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public UserRole getRole() {
        return role;
    }

    public void sendMessage(String content, String category) {
        Message message = new Message(content, category);
        System.out.println(name + " sends: [" + category + "] " + content);
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(Message message) {
        System.out.println(name + " receives: [" + message.getCategory() + "] " + message.getContent());
    }
}
