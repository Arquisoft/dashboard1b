package asw.DBManagement.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;

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
public class SugerenciaTest {
	private String nombre;
	private int numeroComentarios;
	private int numeroApoyos;
	private int numeroContra;
	private Sugerencia suge;
	@Before
	public void setUp() throws Exception {
		nombre = "nombreToWapo";
		numeroComentarios = 15;
		numeroApoyos = 10;
		numeroContra = 2;
		suge = new Sugerencia(nombre, numeroComentarios, numeroApoyos, numeroContra);
				
		
	}
	@After
	public void tearDown() throws Exception {

	}
	
	@Test
	public void getNombre() throws Exception{
		assertThat(suge.getNombre()).isEqualTo(nombre);
	}
	@Test
	public void setNombre() throws Exception{
		suge.setNombre("nombreNuevo");
		assertThat(suge.getNombre()).isEqualTo("nombreNuevo");
		
	}
	@Test
	public void getNumeroComentarios() throws Exception{
		
		assertThat(suge.getNumeroComentarios()).isEqualTo(numeroComentarios);
	}
	
	@Test
	public void getNumeroComentarios1() throws Exception{
		
		//assertThat(suge.getNumeroComentarios()).isEqualTo(numeroComentarios);
		assertThat(suge.getNumeroComentarios()).isEqualTo(15);
	}
	@Test
	public void setNumeroComentarios() throws Exception{
		suge.setNumeroComentarios(1);
		assertThat(suge.getNumeroComentarios()).isEqualTo(1);
	}
	@Test
	public void getNumeroApoyos() throws Exception{
		
		assertThat(suge.getNumeroApoyos()).isEqualTo(numeroApoyos);
	}
	@Test
	public void getNumeroApoyos1() throws Exception{
		
		assertThat(suge.getNumeroApoyos()).isEqualTo(10);
	}
	
}
