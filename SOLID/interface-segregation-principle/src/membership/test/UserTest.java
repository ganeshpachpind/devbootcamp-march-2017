import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeAbleToGetUserName() {
        User user = new User("username", "password");

        assertThat(user.getUserName(), is(equalTo("username")));
    }

    @Test
    public void getPassword() {
        User user = new User("username", "password");

        assertThat(user.getPassword(), is(equalTo("password")));
    }

}