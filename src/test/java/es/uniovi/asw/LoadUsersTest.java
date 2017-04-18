package es.uniovi.asw;

import org.junit.Test;

import es.uniovi.asw.dbupdate.Database;
import static org.junit.Assert.*;

public class LoadUsersTest {

	@Test
	public void testRun(){
		Database.getDatabase();
		LoadUsers loader = new LoadUsers();
		
		String args[] = null;
		assertEquals(loader.run(args),"Error irrecuperable, reinicie la aplicacion");
		LoadUsers.main(args);
		
		args = new String[0];
		assertEquals(loader.run(args),"Error en la entrada, teclee -help para ver la ayuda");
		
		args = new String[1];
		args[0] = "src/test/resources/test.xlsx";
		assertEquals(loader.run(args),"por defecto");
		
		args[0] = "-help";
		assertEquals(loader.run(args),"ayuda");
		
		args = new String[2];
		args[0] = "src/test/resources/test.xlsx";
		args[1] = "-w";
		assertEquals(loader.run(args),"parametros");
		
		args[1] = "-d";
		assertEquals(loader.run(args),"parametros");
		
		args[1] = "-p";
		assertEquals(loader.run(args),"parametros");
		
		args[1] = "-a";
		assertEquals(loader.run(args),"error");
			
		args[1] = "123";
		assertEquals(loader.run(args),"error");
		
		args = new String[5];
		for(int i=0;i < args.length;i++)
			args[i] ="";
		assertEquals(loader.run(args),"error");
	}
}
