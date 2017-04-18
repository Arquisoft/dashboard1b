package es.uniovi.asw.dbupdate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import es.uniovi.asw.ReportWriter.WriteReport;

public class WReportR implements WriteReport{

	@Override
	public void log(String datos) {
		File file = new File("log.txt");
		try {
			FileWriter fW = new FileWriter(file, true);
			fW.write(new Date() + " - " + datos + "\n");
			fW.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
