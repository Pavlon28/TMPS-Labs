package Lab_2.src.utilities;

import Lab_2.src.domain.TargetInterface;

public class Adapter implements TargetInterface {
    private final LegacySystem legacySystem;

    public Adapter(LegacySystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void performStandardAction() {
        System.out.println("Adapter converting legacy action...");
        legacySystem.legacyAction();
    }
}
