package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import es.uniovi.asw.dbupdate.Database;
import es.uniovi.asw.parser.RListExcel;
import es.uniovi.asw.parser.ReadList;

public class RListTest {
	
	@Test
	public void readFile(){
		Database.getDatabase();
		ReadList reader = new RListExcel("src/test/resources/test.xlsx");
			List<CitizenDB> citizens = reader.read();
			assertEquals(citizens.get(0).getSurname(), "Torres Pardo");
			assertEquals(citizens.get(1).getSurname(), "López Fernando");
			assertEquals(citizens.get(2).getSurname(), "Torres Pardo");

			assertEquals(citizens.get(0).getName(), "Juan");
			assertEquals(citizens.get(1).getName(), "Luis");
			assertEquals(citizens.get(2).getName(), "Ana");

			assertEquals(citizens.get(0).getMail(), "juan@example.com");
			assertEquals(citizens.get(1).getMail(), "luis@example.com");
			assertEquals(citizens.get(2).getMail(), "ana@example.com");
			
			assertEquals(citizens.get(0).getNationality(), "Español");
			assertEquals(citizens.get(1).getNationality(), "Español");
			assertEquals(citizens.get(2).getNationality(), "Español");
			
			assertEquals(citizens.get(0).getDNI(), "90500084Y");
			assertEquals(citizens.get(1).getDNI(), "19160962F");
			assertEquals(citizens.get(2).getDNI(), "09940449X");
			
			assertEquals(citizens.get(0).getAddress(), "C/ Federico García Lorca 2");
			assertEquals(citizens.get(1).getAddress(), "C/ Real Oviedo 2");
			assertEquals(citizens.get(2).getAddress(), "Av. De la Constitución 8");
	}
	
	@Test
	public void test() {
		this.readFile();
	}

}
