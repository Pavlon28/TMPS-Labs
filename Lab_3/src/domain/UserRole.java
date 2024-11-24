package Lab_3.src.domain;

public enum UserRole {
    REGULAR(1),
    PREMIUM(2);

    private final int priority;

    UserRole(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
