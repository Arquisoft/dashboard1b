package asw.participants_original.acceso;

import asw.Application;
import asw.participants_original.acceso.ChangePassword;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ChangePasswordTest {

    private ChangePassword changePassword;

    private String email;
    private String password;
    private String newPassword;


    @Before
    public void setUp() throws Exception {
        email = "email@email.net";
        password = "oldPassword";
        newPassword = "newPassword";
        changePassword = new ChangePassword(email, password, newPassword);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstructor() throws Exception {
        assertThat(new ChangePassword()).isNotNull();
    }

    @Test
    public void getPassword() throws Exception {

        assertThat(changePassword.getPassword()).isEqualTo(password);
    }

    @Test
    public void getEmail() throws Exception {
        assertThat(changePassword.getEmail()).isEqualTo(email);
    }

    @Test
    public void getNewPassword() throws Exception {
        assertThat(changePassword.getNewPassword()).isEqualTo(newPassword);
    }

    @Test
    public void testToString() throws Exception {
        assertThat(changePassword.toString()).isEqualTo("ChangeInfo [password=" + password + ", email=" + email + ", newPassword=" + newPassword + "]");
    }
}