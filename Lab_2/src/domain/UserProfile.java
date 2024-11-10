package Lab_2.src.domain;

public class UserProfile {
    private String name;
    private String email;
    private int loginCount;

    public UserProfile(String name, String email) {
        this.name = name;
        this.email = email;
        this.loginCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getLoginCount() {
        return loginCount;
    }

    public void incrementLoginCount() {
        this.loginCount++;
    }

    @Override
    public String toString() {
        return "UserProfile{name='" + name + "', email='" + email + "', loginCount=" + loginCount + "}";
    }
}

