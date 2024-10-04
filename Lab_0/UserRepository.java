package Lab_0;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        System.out.println("Added: " + user);
    }

    public void updateUser(int userId, String name, String email) {
        User user = users.get(userId);
        if (user == null) {
            System.out.println("User with ID " + userId + " not found.");
            return;
        }
        if (name != null) {
            user.setName(name);
        }
        if (email != null) {
            user.setEmail(email);
        }
        System.out.println("Updated: " + user);
    }

    public void deleteUser(int userId) {
        User user = users.remove(userId);
        if (user != null) {
            System.out.println("Deleted: " + user);
        } else {
            System.out.println("User with ID " + userId + " not found.");
        }
    }

    public User getUser(int userId) {
        return users.get(userId);
    }
}

