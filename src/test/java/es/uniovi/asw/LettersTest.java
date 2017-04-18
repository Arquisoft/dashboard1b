package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.uniovi.asw.parser.GenerationPassword;
import es.uniovi.asw.letters.*;

public class LettersTest {
	
	private AbstractWriteLetter writer;
	private List<CitizenDB> citizens = new ArrayList<CitizenDB>();
	private final String RUTA = "src/main/resources/letters/";
	
	@Test
	public void testDefaultLetter(){
		this.createUsers();
		writer = new DefaultLetter(citizens,"");
		assertEquals(writer.getPath(),"src/main/resources/letters/");
		assertEquals(writer.getMessage(),"");
		writer.setMessage("Mensaje de prueba");
		assertEquals(writer.getMessage(),"Mensaje de prueba");
		for(CitizenDB c : citizens)
			try {
				writer.write(c);
				File file = new File(this.RUTA+"plainText/"+c.getName()+".txt");
				assertTrue(file.exists());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		this.deleteUsers();
	}
	
	@Test
	public void testWordLetter(){
		this.createUsers();
		writer = new WordLetter(citizens,"");
		assertEquals(writer.getPath(),"src/main/resources/letters/");
		assertEquals(writer.getMessage(),"");
		writer.setMessage("Mensaje de prueba");
		assertEquals(writer.getMessage(),"Mensaje de prueba");
		for(CitizenDB c : citizens)
			try {
				writer.write(c);
				File file = new File(this.RUTA+"doc/"+c.getName()+".doc");
				assertTrue(file.exists());
			}			
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		this.deleteUsers();
	}
	
	
	@Test
	public void testPDFLetter(){
		this.createUsers();
		writer = new PDFLetter(citizens,"");
		assertEquals(writer.getPath(),"src/main/resources/letters/");
		assertEquals(writer.getMessage(),"");
		writer.setMessage("Mensaje de prueba");
		assertEquals(writer.getMessage(),"Mensaje de prueba");
		for(CitizenDB c : citizens)
			try {
				writer.write(c);
				File file = new File(this.RUTA+"PDF/"+c.getName()+".pdf");
				assertTrue(file.exists());
			}			
			catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		this.deleteUsers();
	}
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testPDPFileNotFound() throws FileNotFoundException{
		try{
			writer = new PDFLetter(citizens,"prueba");
			writer.setPath("/ruta/Inventada");
			assertEquals(writer.getPath(),"/ruta/Inventada");
			writer.write(new CitizenDB("Juan","Rodriguez Garcia","juan@gmail.com",new Date(1234),"C/la luna","España","71654234J"));
			exception.expect(FileNotFoundException.class);
		}
		catch(FileNotFoundException e){
			System.err.println("Ruta inválida: \""+writer.getPath()+"\"");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	
	public void testDocFileNotFound() throws FileNotFoundException{
		try{
			writer = new WordLetter(citizens,"prueba");
			writer.setPath("/ruta/Inventada");
			assertEquals(writer.getPath(),"/ruta/Inventada");
			writer.write(new CitizenDB("Juan","Rodriguez Garcia","juan@gmail.com",new Date(1234),"C/la luna","España","71654234J"));
			exception.expect(FileNotFoundException.class);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createUsers(){
		citizens.add(new CitizenDB("Juan","Rodriguez Garcia","juan@gmail.com",new Date(1234),"C/la luna","España","71654234J"));
		citizens.add(new CitizenDB("Marta","Rodriguez Garcia","marta@gmail.com",new Date(1234),"C/paraiso","España","71654233J"));
		citizens.add(new CitizenDB("Elena","Perez Garcia","elena@gmail.com",new Date(1234),"C/paraiso","España","71644233G"));
		citizens.add(new CitizenDB("Daniel","Perez Perez","dani@gmail.com",new Date(1234),"C/Lugones","España","73334233K"));
		citizens.add(new CitizenDB("Jose","Perez Garcia","jose@gmail.com",new Date(1234),"C/paraiso","España","11144233G"));
		for(CitizenDB c:citizens)
			c.setPassword(new GenerationPassword().passwordGenerator());
	}
	
	private void deleteUsers(){
		for(int i=0;i < this.citizens.size();i++)
			this.citizens.remove(i);
	}
}
