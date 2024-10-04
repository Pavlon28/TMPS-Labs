package Lab_0;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepo = new UserRepository();

        // Create and add a user
        User user1 = new User(1, "John Doe", "john@example.com");
        userRepo.addUser(user1);

        // Update a user
        userRepo.updateUser(1, "John Smith", null);

        // Delete a user
        userRepo.deleteUser(1);
    }
}
