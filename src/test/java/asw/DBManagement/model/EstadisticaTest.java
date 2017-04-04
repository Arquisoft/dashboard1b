package asw.DBManagement.model;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import asw.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class EstadisticaTest {

    private Estadistica est;
    private String titulo;
    private List<String> c;
    private List<Double> v;

    @Before
    public void setUp() throws Exception {
        titulo = "pedazoTitulo";
        Map<String, Integer> campos = new HashMap<>();

        campos.put("campo1", 23);
        campos.put("campo2", 17);

        est = new Estadistica(titulo, campos);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getTitulo() throws Exception {
        assertThat(est.getTitulo()).isEqualTo(titulo);
    }

    @Test
    public void setTitulo() throws Exception {
        est.setTitulo("Titulo2");
        assertThat(est.getTitulo()).isEqualTo("Titulo2");
    }

    @Test
    public void getCampos() throws Exception {
        assertThat(est.getCampos()).isEqualTo(est.getCampos());
    }

    @Test
    public void getCampos1() throws Exception {
        assertThat(est.getCampos().size()).isEqualTo(2);
    }

    @Test
    public void setCampos() throws Exception {
        Map<String, Integer> campos = new HashMap<>();
        campos.put("campo3", 42);
        est.setCampos(campos);
        assertThat(est.getCampos()).isEqualTo(campos);

    }

    @Test
    public void setCampos1() throws Exception {
        Map<String, Integer> campos = new HashMap<>();
        campos.put("campo3", 42);
        est.setCampos(campos);
        assertThat(est.getCampos().size()).isEqualTo(1);
    }

    @Test
    public void getValores() throws Exception {
        assertThat(est.getCampos().isEmpty());
    }

    /*
    @Test
    public void setValores() throws Exception {
        List<Double> lista = new ArrayList<Double>();
        lista.add(2.3);
        est.setValores(lista);

        assertThat(est.getValores()).isEqualTo(lista);
    }

    @Test
    public void setValores1() throws Exception {
        List<Double> lista = new ArrayList<Double>();
        lista.add(2.3);
        est.setValores(lista);

        assertThat(est.getValores().size()).isEqualTo(1);
    }*/

}
