package Lab_2.src.utilities;

import Lab_2.src.domain.TargetInterface;
import Lab_2.src.domain.UserProfile;

public class Adapter implements TargetInterface {
    private final LegacyUser legacyUser;

    public Adapter(LegacyUser legacySystem) {
        this.legacyUser = legacySystem;
    }

    public UserProfile adaptUserProfile() {
        String name = legacyUser.getUserName();
        String email = legacyUser.getUserEmail();
        System.out.println("Adapter creating UserProfile from legacy data...");
        return new UserProfile(name, email);
    }

    @Override
    public void performStandardAction() {
        UserProfile user = adaptUserProfile();
        System.out.println("Adapted UserProfile: " + user);
    }
}
