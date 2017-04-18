package asw.participants_original.acceso;

import asw.Application;
import asw.DBManagement_original.model.Ciudadano;
import asw.participants_original.acceso.ParticipantsInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ParticipantsInfoTest {

    private String firstName;
    private String lastName;
    private long edad;
    private Date bornDate;
    private String nif;
    private String email;


    private ParticipantsInfo participantsInfo;


    @Before
    public void setUp() throws Exception {
        firstName = "John";
        lastName = "Doe";
        email = "john@doe.net";
        edad = 47;
        nif = "12345678V";
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        participantsInfo = new ParticipantsInfo(firstName, lastName, bornDate, nif, email);

    }

    @Test
    public void testConstructor() throws  Exception {
        assertThat(new ParticipantsInfo(new Ciudadano(firstName,lastName,email,bornDate,nif,"","","")));
    }

    @Test
    public void getFirstName() throws Exception {
        assertThat(participantsInfo.getFirstName()).isEqualTo(firstName);
    }

    @Test
    public void getLastName() throws Exception {
        assertThat(participantsInfo.getLastName()).isEqualTo(lastName);
    }

    @Test
    public void getEdad() throws Exception {
        assertThat(participantsInfo.getEdad()).isEqualTo(edad);
    }

    @Test
    public void getNif() throws Exception {
        assertThat(participantsInfo.getNif()).isEqualTo(nif);

    }

    @Test
    public void getEmail() throws Exception {
        assertThat(participantsInfo.getEmail()).isEqualTo(email);
    }

    @Test
    public void equals() throws Exception {
        assertThat(participantsInfo.equals(participantsInfo)).isTrue();
        assertThat(participantsInfo.equals(null)).isFalse();
        assertThat(participantsInfo.equals(email)).isFalse();
        ParticipantsInfo participantsInfo2 = participantsInfo;
        assertThat(participantsInfo.equals(participantsInfo2)).isTrue();
    }

    @Test
    public void testToString() throws  Exception {
        assertThat(participantsInfo.toString()).isEqualTo("ParticipantsInfo [firstName=" + firstName + ", lastName=" + lastName + ", edad=" + edad + ", nif=" + nif
                + ", email=" + email + "]");
    }

    @Test
    public void testHashCode() throws Exception{
        assertThat(participantsInfo.hashCode()).isNotNull();
    }

}