package Lab_2.src.client;

import Lab_2.src.domain.UserProfile;
import Lab_2.src.utilities.SystemFacade;

public class MainClient {
    public static void main(String[] args) {
        SystemFacade facade = new SystemFacade();

        // Step 1: Initialize UserProfile using Adapter pattern
        UserProfile user = facade.initializeUserProfile();

        // Step 2: Perform user operation with Decorator pattern adding logging and validation
        facade.performUserOperation(user);

        // Step 3: Manage user session with additional subsystems using Facade pattern
        facade.manageUserSession(user);
    }
}
