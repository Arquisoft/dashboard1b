package asw.DBManagement;

import asw.Application;
import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;
import asw.participants.acceso.ParticipantsLogin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GetParticipantTest {

    @Autowired
    private CiudadanoRepository repository;

    @Autowired
    private GetParticipant getParticipant;

    private Ciudadano johnDoe;

    private ParticipantsLogin johnDoeLogin;


    @Before
    public void setUp() throws Exception {
        Date bornDate;

        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            johnDoe = new Ciudadano("John", "Doe", "john@doe.net", bornDate, "Phobos", "Martian", "123456789", "password", false);
            johnDoeLogin = new ParticipantsLogin(johnDoe.getEmail(),johnDoe.getPassword());
            repository.save(johnDoe);

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCiudadano() throws Exception {
        assertThat(johnDoe).isNotNull();
        assertThat(getParticipant.getCiudadano(johnDoe.getEmail())).isNotNull();
    }

    @Test
    public void getCiudadano1() throws Exception {
        assertThat(johnDoe).isNotNull();
        assertThat(getParticipant.getCiudadano(johnDoeLogin)).isNotNull();
    }
    
    
    
}