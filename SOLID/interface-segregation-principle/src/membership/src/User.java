import lombok.Getter;

@Getter
public class User {
    private final String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
