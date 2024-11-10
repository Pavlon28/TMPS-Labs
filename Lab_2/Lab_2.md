# Structural Design Patterns Lab

**Author:** Pavel Tapu

## Introduction

In this project, I focused on implementing three structural design patterns: **Adapter**, **Decorator**, and **Facade**. Each pattern helps make the code more modular, allowing us to connect components in a clean way without exposing complex details to the user. The Adapter pattern lets us reuse older parts of the system, the Decorator pattern helps add features without changing core classes, and the Facade pattern keeps things simple by creating a single access point for the client.

## Theory and Purpose

Structural patterns help make systems more flexible and easier to understand by arranging and connecting classes or objects in different ways. For this lab, the requirements were:

1) Implement at least three structural design patterns to improve the main tasks of the system.
2) Use patterns in a way that hides object creation logic from the client.
3) Ensure the client only interacts through a single entry point.

Using these patterns made it easier to manage and extend the system, especially when working with multiple functionalities.

## Implementation

### Adapter Pattern

The **Adapter** pattern acts like a bridge, converting data from a legacy system so that it fits with our new system. In this project, I created an **Adapter** class to transform old data into a new `UserProfile` format. This makes it easier to use older data without needing to rewrite everything.

**Code Snippet:**
```java
// In Adapter.java
public class Adapter {
private LegacyUser legacyUser;

    public Adapter(LegacyUser legacyUser) {
        this.legacyUser = legacyUser;
    }

    public UserProfile adaptUserProfile() {
        System.out.println("Adapter creating UserProfile from legacy data...");
        return new UserProfile(legacyUser.getName(), legacyUser.getEmail(), legacyUser.getLoginCount());
    }
}
```
The `Adapter` class uses the `LegacyUser` object, converting its data into a `UserProfile` object with the correct structure (`name`, `email`, and `loginCount`). This way, we can continue using the new system without losing compatibility with old data sources.

### Decorator Pattern

The **Decorator** pattern allows us to add extra functionalities like logging and validation without modifying the main classes directly. Here, I added two decorators, `LoggingDecorator` and `ValidationDecorator`, which both wrap around the core component. This makes the main component more powerful with added features.

**Code Snippet:**
```java
// In LoggingDecorator.java
public class LoggingDecorator extends Component {
private Component wrappedComponent;

    public LoggingDecorator(Component wrappedComponent) {
        this.wrappedComponent = wrappedComponent;
    }

    @Override
    public void execute() {
        System.out.println("[LoggingDecorator] Starting execution...");
        wrappedComponent.execute();
        System.out.println("[LoggingDecorator] Execution completed.");
    }
}

// In ValidationDecorator.java
public class ValidationDecorator extends Component {
private Component wrappedComponent;

    public ValidationDecorator(Component wrappedComponent) {
        this.wrappedComponent = wrappedComponent;
    }

    @Override
    public void execute() {
        System.out.println("[ValidationDecorator] Validating input...");
        // Add validation logic here
        wrappedComponent.execute();
        System.out.println("[ValidationDecorator] Validation successful.");
    }
}
```

In `MainClient`, the Decorators wrap around each other, creating layers of functionality:

```java
// In MainClient.java
Component component = new ValidationDecorator(new LoggingDecorator(new ConcreteComponent(userProfile)));
component.execute();
```

With this setup, `execute()` first validates, then logs, and finally runs the core task. Adding and removing functionality is easy—just change which decorators are used.

### Facade Pattern

The **Facade** pattern is a simple interface for the client to use without needing to know about all the different subsystems. In this case, `SystemFacade` coordinates tasks for a user session by managing initialization, updates, and logging across `SubsystemA` and `SubsystemB`. This lets the client interact with just one class to manage multiple tasks, hiding the details of each subsystem.

**Code Snippet:**

```java
// In SystemFacade.java
public class SystemFacade {
private SubsystemA subsystemA;
private SubsystemB subsystemB;

    public SystemFacade() {
        subsystemA = new SubsystemA();
        subsystemB = new SubsystemB();
    }

    public void manageUserSession(UserProfile user) {
        System.out.println("SystemFacade managing user session...");
        subsystemA.initializeUser(user);
        subsystemB.updateUser(user);
        System.out.println("Session management completed for user: " + user);
    }
}
```
The Facade (`SystemFacade`) is a high-level class that interacts with `SubsystemA` and `SubsystemB`, so the client only has to call `manageUserSession()` and everything else is handled behind the scenes. This keeps the code organized and lets me change the internal implementation without impacting the client.

## Conclusion

In this project I have showed how structural patterns can make a system more adaptable and organized. The Adapter pattern is useful for connecting older data formats to the new system by transforming legacy data into the new `UserProfile` format. The Decorator pattern helped me add logging and validation as extra functionalities to the main component without changing its original code. This way, I could add more features as needed while keeping the core logic intact. Finally, the Facade pattern simplified the client interface by coordinating different subsystems through a single `SystemFacade`, making the interactions straightforward and the system easier to manage. All together, these patterns created a flexible and maintainable structure, helping the system handle different tasks and making it easy to add new features or make changes in the future.