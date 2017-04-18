package es.uniovi.asw;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.junit.Test;

import es.uniovi.asw.dbupdate.Database;
import es.uniovi.asw.dbupdate.Insert;
import es.uniovi.asw.dbupdate.InsertP;
import es.uniovi.asw.dbupdate.Jpa;


/**
 * @author oliver
 *
 */
public class DataBaseTest {
	

	@Test
	public void test() throws Exception {
		ArrayList<CitizenDB> citizenDBs = new ArrayList<CitizenDB>();
		int numeroAntes  = numberCitizen();
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yy");
		for(int i = 0; i<9 ; i++){
			Date date =  d.parse((1+i)+"-03-1996");
			CitizenDB citizenDB  = new CitizenDB("Nombre"+i,"Apellidos"+i,"email"+i+"@gmail.com",date,
					"Calle"+i,"España", generatorDNI()+"A");
			citizenDBs.add(citizenDB);
		}
			Insert insert = new InsertP();		
			
			insert.insert(citizenDBs);
		int numeroDespues = numberCitizen();
		assertTrue(numeroAntes<numeroDespues);
	}
	
	@Test
	public void createTabletest() throws Exception {
		assertTrue(Database.getDatabase().existTable());
		removeTable();
		assertFalse(Database.getDatabase().existTable());	
               
	}
	
	private int numberCitizen(){
		EntityManager em = Jpa.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		try{
			
			Query query = Jpa.getManager().createQuery("select c from CitizenDB c");
			return query.getResultList().size();
	        
		}catch(RuntimeException e){
			trx.rollback();
	    	throw e;
		}
		finally{
			em.close();
		}
	}
	
	private void removeTable(){
		Connection connection = null;
		Statement st = null;
		try {
			connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			st = connection.createStatement();
			st.execute("DROP TABLE PERSONA");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				st.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Object generatorDNI() {
		Random random = new Random();
		String dni = "";
		for(int i = 0 ; i<8; i++){
			dni = dni + random.nextInt(9);
		}
		return dni;
			
	}
}

