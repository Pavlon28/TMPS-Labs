package Lab_2.src.models;

import Lab_2.src.domain.Component;
import Lab_2.src.domain.UserProfile;

public class ConcreteComponent implements Component {
    private final UserProfile user;

    public ConcreteComponent(UserProfile user) {
        this.user = user;
    }

    @Override
    public void execute() {
        System.out.println("Executing core functionality for user: " + user.getName());
        user.incrementLoginCount();
        System.out.println("Login count updated: " + user.getLoginCount());
    }
}
