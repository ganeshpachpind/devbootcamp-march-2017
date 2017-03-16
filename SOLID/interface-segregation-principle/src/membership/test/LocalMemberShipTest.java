import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemErrRule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class LocalMemberShipTest {

    @Rule
    public final SystemErrRule systemErrRule = new SystemErrRule().enableLog();

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("superstar", "password");
    }

    @Test
    public void shouldBeAbleToRequestForgotPassword() {
        String message = String.format("user '%s': requested for new password", user.getUserName());
        ForgotPassword localMemberShip = new LocalMemberShip();

        localMemberShip.forgotPassword(user);

        assertThat(systemErrRule.getLogWithNormalizedLineSeparator(), is(equalTo(message)));
    }

    @Test
    public void shouldBeAbleToLogin() {
        String message = String.format("user '%s' logged in", user.getUserName());
        Login localMemberShip = new LocalMemberShip();

        localMemberShip.login(user);
        assertThat(systemErrRule.getLogWithNormalizedLineSeparator(), is(equalTo(message)));
    }

    @Test
    public void shouldBeAbleToLogout() {
        String message = String.format("user '%s' logged out", user.getUserName());
        Login localMemberShip = new LocalMemberShip();

        localMemberShip.logout(user);
        assertThat(systemErrRule.getLogWithNormalizedLineSeparator(), is(equalTo(message)));
    }

    @Test
    public void shouldBeAbleToRegister() {
        String message = String.format("user '%s' has been registered successfully", user.getUserName());
        Register localMemberShip = new LocalMemberShip();

        localMemberShip.register(user);
        assertThat(systemErrRule.getLogWithNormalizedLineSeparator(), is(equalTo(message)));
    }
}