package Lab_2.src.utilities;

import Lab_2.src.domain.TargetInterface;
import Lab_2.src.domain.UserProfile;

public class Adapter implements TargetInterface {
    private final LegacySystem legacySystem;

    public Adapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    public UserProfile adaptUserProfile() {
        String name = legacySystem.getUserName();
        String email = legacySystem.getUserEmail();
        System.out.println("Adapter creating UserProfile from legacy data...");
        return new UserProfile(name, email);
    }

    @Override
    public void performStandardAction() {
        UserProfile user = adaptUserProfile();
        System.out.println("Adapted UserProfile: " + user);
    }
}
