package Lab_3.src.client;

import Lab_3.src.domain.User;
import Lab_3.src.domain.UserRole;
import Lab_3.src.utilities.HelpDeskMediator;

public class Main {
    public static void main(String[] args) {
        // Create the mediator
        HelpDeskMediator mediator = new HelpDeskMediator();

        // Create users and register them
        User alice = new User("Alice", UserRole.REGULAR, mediator);
        User bob = new User("Bob", UserRole.PREMIUM, mediator);
        User helpDeskAgent = new User("HelpDeskAgent", UserRole.PREMIUM, mediator);

        mediator.registerUser(alice);
        mediator.registerUser(bob);
        mediator.registerUser(helpDeskAgent);

        // Simulate message exchanges
        alice.sendMessage("I need help resetting my password.", "Technical");
        bob.sendMessage("I have a billing issue.", "Billing");
        helpDeskAgent.sendMessage("I'll assist you both shortly.", "General");
    }
}
