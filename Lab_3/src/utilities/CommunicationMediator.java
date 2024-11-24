package Lab_3.src.utilities;

import Lab_3.src.domain.Message;
import Lab_3.src.domain.User;

public interface CommunicationMediator {
    void sendMessage(Message message, User sender);
    void registerUser(User user);
}
