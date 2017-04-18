package es.uniovi.asw.ReportWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class WreportP implements WriteReport{

	@Override
	public void log(String datos) {		
		File file = new File("logP.txt");

		try {				

			FileWriter fW = new FileWriter(file, true);
			fW.write(new Date()+" - "+datos+"\n");
			fW.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}


