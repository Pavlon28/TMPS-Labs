package Lab_2.src.models;

import Lab_2.src.domain.Component;
import Lab_2.src.domain.UserProfile;

public class ValidationDecorator implements Component {
    private final Component wrappedComponent;
    private final UserProfile user;

    public ValidationDecorator(Component wrappedComponent, UserProfile user) {
        this.wrappedComponent = wrappedComponent;
        this.user = user;
    }

    @Override
    public void execute() {
        if (user.getEmail() == null || user.getName() == null) {
            System.out.println("[ValidationDecorator] Validation failed: Missing user data");
        } else {
            System.out.println("[ValidationDecorator] Validation successful");
            wrappedComponent.execute();
        }
    }
}
