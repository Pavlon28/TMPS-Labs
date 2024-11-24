package Lab_3.src.utilities;

import Lab_3.src.domain.Message;
import Lab_3.src.domain.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HelpDeskMediator implements CommunicationMediator {
    private final List<User> users = new ArrayList<>();

    @Override
    public void sendMessage(Message message, User sender) {
        System.out.println("Processing message from: " + sender.getName() + " (Priority: " + sender.getRole() + ")");
        users.stream()
                .filter(user -> user != sender) // Do not send the message back to the sender
                .sorted(Comparator.comparingInt(user -> -user.getRole().getPriority())) // Prioritize premium users
                .forEach(user -> user.receiveMessage(message));
    }

    @Override
    public void registerUser(User user) {
        users.add(user);
    }
}
