package asw.participants_original.acceso;

import asw.Application;
import asw.participants_original.acceso.ParticipantsLogin;

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
public class ParticipantsLoginTest {

    private String password;
    private String email;

    private  ParticipantsLogin participantsLogin;

    @Before
    public void setUp() throws Exception {
        email = "test@mail.net";
        password = "password";
        participantsLogin = new ParticipantsLogin(email,password);
    }

    @Test
    public void getPassword() throws Exception {
        assertThat(participantsLogin.getPassword()).isEqualTo(password);
    }

    @Test
    public void getEmail() throws Exception {
        assertThat(participantsLogin.getEmail()).isEqualTo(email);
    }

    @Test

    public void testToString() throws Exception  {
        assertThat(participantsLogin.toString()).isEqualTo("ParticipantsLogin [password=" + password + ", email=" + email + "]");
    }

}