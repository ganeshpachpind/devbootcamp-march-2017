import java.util.UUID;

public class LocalMemberShip implements Login, Register, ForgotPassword {
    @Override
    public void forgotPassword(User user) {
        System.console().printf("Hello");
//        System.console().format("user '%s': requested for new password", user.getUserName());
    }

    @Override
    public boolean login(User user) {
        System.console().format("user '%s' logged in", user.getUserName());
        return false;
    }

    @Override
    public void logout(User user) {
        System.console().format("user '%s' logged out", user.getUserName());
    }

    @Override
    public UUID register(User user) {
        System.console().format("user '%s' has been registered successfully", user.getUserName());
        return null;
    }
}
