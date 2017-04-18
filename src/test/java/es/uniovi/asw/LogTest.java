package es.uniovi.asw;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import es.uniovi.asw.ReportWriter.WreportP;
import es.uniovi.asw.dbupdate.WReportR;

public class LogTest {

	WReportR logTest = new WReportR();
	WreportP logTest2 = new WreportP();
	
	@Test
	public void logTest() {
		String prueba = "Test de prueba para el log";
		
		logTest.log(prueba);
		
		try {
			FileReader file = new FileReader("log.txt");
			BufferedReader fileR = new BufferedReader(file);
			
			String line;
			while((line = fileR.readLine()) != null && !line.contains("Test de prueba para el log"));
			
			assertTrue(line.contains("Test de prueba para el log"));
			
			fileR.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void logTest2() {
		String prueba = "Test de prueba para el log WReportP";
		
		logTest2.log(prueba);
		
		try {
			FileReader file = new FileReader("logP.txt");
			BufferedReader fileR = new BufferedReader(file);
			String line;
			while((line = fileR.readLine()) != null && !line.contains("Test de prueba para el log WReportP"));
			assertTrue(line.contains("Test de prueba para el log WReportP"));
			
			fileR.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		
	}

}
