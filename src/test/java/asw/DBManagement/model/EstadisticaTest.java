package asw.DBManagement.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

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
	titulo  = "pedazoTitulo";
	c  = new ArrayList<String>();
	v  = new ArrayList<Double>();
	c.add("campo1");
	c.add("campo2");
	v.add(23.0);
	v.add(17.4);
	
	est = new Estadistica(titulo,c,v);
}
@After
public void tearDown() throws Exception {

}
@Test
public void getTitulo() throws Exception {
    assertThat(est.getTitulo()).isEqualTo(titulo);
}
@Test
public void setTitulo() throws Exception{
	est.setTitulo("Titulo2");
	assertThat(est.getTitulo()).isEqualTo("Titulo2");
}

@Test
public void getCampos() throws Exception{
	assertThat(est.getCampos()).isEqualTo(c);
}
@Test
public void getCampos1() throws Exception{
	assertThat(est.getCampos().size()).isEqualTo(2);
}
@Test
public void setCampos() throws Exception{
	List<String> lista = new ArrayList<String>();
	lista.add("campoNuevo");
	est.setCampos(lista);
	assertThat(est.getCampos()).isEqualTo(lista);
	
}
@Test
public void setCampos1() throws Exception{
	List<String> lista = new ArrayList<String>();
	lista.add("campoNuevo");
	est.setCampos(lista);
	assertThat(est.getCampos().size()).isEqualTo(1);
}
}
