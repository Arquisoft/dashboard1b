package asw.DBManagement_original.model;

import asw.Application;
import asw.DBManagement_original.model.Ciudadano;

import org.junit.After;
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
public class CiudadanoTest {

    private Ciudadano johnDoe;

    private String nombre;
    private String apellidos;
    private String email;
    private Date fechaNacimiento;
    private String residencia;
    private String nacionalidad;
    private String dni;
    private String password;


    @Before
    public void setUp() throws Exception {
        Date bornDate = null;
        nombre = "John";
        apellidos = "Doe";
        email = "john@doe.net";
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
            fechaNacimiento = bornDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        residencia = "Phobos";
        nacionalidad = "Martian";
        dni = "12345678X";
        password = "password";

        johnDoe = new Ciudadano(nombre, apellidos, email, bornDate, residencia, nacionalidad, dni, password);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getNombre() throws Exception {
        assertThat(johnDoe.getNombre()).isEqualTo(nombre);
    }

    @Test
    public void setNombre() throws Exception {
        johnDoe.setNombre("nombre");
        assertThat(johnDoe.getNombre()).isEqualTo("nombre");
    }

    @Test
    public void getApellidos() throws Exception {
        assertThat(johnDoe.getApellidos()).isEqualTo(apellidos);
    }

    @Test
    public void setApellidos() throws Exception {
        johnDoe.setApellidos("apellidos");
        assertThat(johnDoe.getApellidos()).isEqualTo("apellidos");
    }

    @Test
    public void getEmail() throws Exception {
        assertThat(johnDoe.getEmail()).isEqualTo(email);
    }

    @Test
    public void setEmail() throws Exception {
        johnDoe.setEmail("email");
        assertThat(johnDoe.getEmail()).isEqualTo("email");
    }

    @Test
    public void getFechaNacimiento() throws Exception {
        assertThat(johnDoe.getFechaNacimiento()).isEqualTo(fechaNacimiento);
    }

    @Test
    public void setFechaNacimiento() throws Exception {
        Date newBornDate;
        try {
            newBornDate = new SimpleDateFormat("yyyy-MM-dd").parse("1942-01-01");
            johnDoe.setFechaNacimiento(newBornDate);
            assertThat(johnDoe.getFechaNacimiento()).isEqualTo(newBornDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getResidencia() throws Exception {
        assertThat(johnDoe.getResidencia()).isEqualTo(residencia);
    }

    @Test
    public void setResidencia() throws Exception {
        johnDoe.setResidencia("Deimos");
        assertThat(johnDoe.getResidencia()).isEqualTo("Deimos");
    }

    @Test
    public void getNacionalidad() throws Exception {
        assertThat(johnDoe.getNacionalidad()).isEqualTo(nacionalidad);
    }

    @Test
    public void setNacionalidad() throws Exception {
        johnDoe.setNacionalidad("Earth");
        assertThat(johnDoe.getNacionalidad()).isEqualTo("Earth");
    }

    @Test
    public void getDni() throws Exception {
        assertThat(johnDoe.getDni()).isEqualTo(dni);
    }

    @Test
    public void setDni() throws Exception {
        johnDoe.setDni("87654321");
        assertThat(johnDoe.getDni()).isEqualTo("87654321");
    }

    @Test
    public void getPassword() throws Exception {
        assertThat(johnDoe.getPassword()).isEqualTo(password);
    }

    @Test
    public void setPassword() throws Exception {
        johnDoe.setPassword("Password");
        assertThat(johnDoe.getPassword()).isEqualTo("Password");
    }
}