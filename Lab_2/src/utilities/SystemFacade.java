package Lab_2.src.utilities;

import Lab_2.src.domain.Component;
import Lab_2.src.domain.UserProfile;
import Lab_2.src.models.ConcreteComponent;
import Lab_2.src.models.LoggingDecorator;
import Lab_2.src.models.ValidationDecorator;

public class SystemFacade {
    private final Adapter adapter;
    private final SubsystemA subsystemA;
    private final SubsystemB subsystemB;

    public SystemFacade() {
        this.adapter = new Adapter(new LegacySystem());
        this.subsystemA = new SubsystemA();
        this.subsystemB = new SubsystemB();
    }

    public UserProfile initializeUserProfile() {
        // Use Adapter pattern to create UserProfile
        return adapter.adaptUserProfile();
    }

    public void performUserOperation(UserProfile user) {
        // Use Decorator pattern to add validation and logging around core operations
        Component component = new ValidationDecorator(new LoggingDecorator(new ConcreteComponent(user)), user);
        component.execute();
    }

    public void manageUserSession(UserProfile user) {
        // Use Facade pattern to interact with multiple subsystems
        System.out.println("SystemFacade managing user session...");
        subsystemA.initializeUser(user);
        subsystemB.updateUser(user);
        System.out.println("Session management completed for user: " + user);
    }
}

