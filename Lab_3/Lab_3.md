# Behavioral Design Patterns - Mediator

## Introduction

This laboratory work focuses on implementing the Mediator design pattern in a help desk system. The Mediator pattern is a behavioral design pattern that simplifies communication between objects by centralizing their interactions. This approach reduces direct dependencies between classes and improves flexibility when adding new functionalities.

In this project, a mediator is used to manage messages between users in a help desk system. Users are categorized as regular or premium, with premium users having higher priority. Additionally, messages are categorized into topics like "Technical" or "Billing" to make the system more organized and realistic.

## Implementation

The project consists of several classes and components that work together to achieve the Mediator pattern:

### Mediator Interface and Implementation 

The `CommunicationMediator` interface defines methods for registering users and sending messages. The `HelpDeskMediator` class implements this interface and routes messages based on user priorities.
```java
public interface CommunicationMediator {
    void sendMessage(Message message, User sender);
    void registerUser(User user);
}
```

The `HelpDeskMediator` ensures that premium users’ messages are prioritized:

```java
public void sendMessage(Message message, User sender) {
    users.stream()
            .filter(user -> user != sender)
            .sorted(Comparator.comparingInt(user -> -user.getRole().getPriority()))
            .forEach(user -> user.receiveMessage(message));
}
```

### User and Role Management

The `User` class represents entities that can send and receive messages. Each user has a role, either **REGULAR** or **PREMIUM**, represented by the `UserRole` enum. This role determines the priority of their messages.

```java
public enum UserRole {
    REGULAR(1), PREMIUM(2);

    private final int priority;

    UserRole(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
```

A user sends a message using the mediator:

```java
public void sendMessage(String content, String category) {
    Message message = new Message(content, category);
    mediator.sendMessage(message, this);
}
```

### Message Class 

The `Message` class encapsulates the message content and category. This makes it easy to classify and route messages efficiently.

```java
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
```

### Client Code 

The `Main` class demonstrates how the system works. Users are registered with the mediator, and they send categorized messages. Premium users’ messages are handled first:

```java
User alice = new User("Alice", UserRole.REGULAR, mediator);
User bob = new User("Bob", UserRole.PREMIUM, mediator);
mediator.registerUser(alice);
mediator.registerUser(bob);

alice.sendMessage("I need help resetting my password.", "Technical");
bob.sendMessage("I have a billing issue.", "Billing");
```

## Conclusion

This project demonstrates how the Mediator pattern can centralize communication and reduce dependencies between objects. By introducing roles and message categories, the system becomes more dynamic and realistic. Premium users’ messages are prioritized, showcasing how this pattern can handle real-world requirements like prioritization and classification. The project structure is clean, with responsibilities grouped into packages, making the code modular and maintainable.

Using the Mediator design pattern has made the system more flexible and easy to extend. For example, adding new roles or message types would only require minimal changes to the existing code. This laboratory work highlights the advantages of behavioral design patterns in improving software communication and organization.