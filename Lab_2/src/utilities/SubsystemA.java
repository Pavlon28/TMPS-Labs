package Lab_2.src.utilities;

import Lab_2.src.domain.UserProfile;

public class SubsystemA {
    public void initializeUser(UserProfile user) {
        System.out.println("SubsystemA initializing user: " + user.getName());
    }
}

