package asw.DBManagement_original;

import asw.Application;
import asw.DBManagement_original.UpdateInfo;
import asw.DBManagement_original.model.Ciudadano;
import asw.DBManagement_original.persistence.CiudadanoRepository;
import asw.participants_original.acceso.ChangePassword;

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
public class UpdateInfoTest {

    @Autowired
    private UpdateInfo updateInfo;

    @Autowired
    private CiudadanoRepository repository;

    private Ciudadano johnDoe;


    private ChangePassword changePassword;

    @Before
    public void setUp() throws Exception {
        Date bornDate;

        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            johnDoe = new Ciudadano("John", "Doe", "john@doe.net", bornDate, "Phobos", "Martian", "123456789", "password");
            repository.save(johnDoe);
            changePassword = new ChangePassword(johnDoe.getEmail(),johnDoe.getPassword(),"newPassword");

        } catch (ParseException e) {

            e.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void updateCitizen() throws Exception {
        assertThat(johnDoe).isNotNull();
        assertThat(updateInfo.UpdateCitizen(johnDoe)).isTrue();
    }

    @Test
    public void updateCitizen1() throws Exception {
        assertThat(johnDoe).isNotNull();
        assertThat(updateInfo.UpdateCitizen(changePassword)).isNotNull();

    }

}