package Lab_2.src.utilities;

import Lab_2.src.domain.UserProfile;

public class SubsystemB {
    public void updateUser(UserProfile user) {
        System.out.println("SubsystemB updating user information...");
        user.incrementLoginCount();
    }
}
