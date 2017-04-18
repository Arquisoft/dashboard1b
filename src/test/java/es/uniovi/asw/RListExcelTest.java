package es.uniovi.asw;


import java.io.FileNotFoundException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import es.uniovi.asw.parser.AdapterPoi;

public class RListExcelTest {

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void notFoundTest() throws FileNotFoundException{
		exception.expect(FileNotFoundException.class);
		new AdapterPoi("ruta");
	}
}
