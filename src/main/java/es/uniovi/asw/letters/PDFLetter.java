package es.uniovi.asw.letters;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.pdf.PdfWriter;

import es.uniovi.asw.CitizenDB;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

/**
 * Clase que implementa la interfaz WriteLetter para el envío de cartas PDF
 * @author david
 *
 */
public class PDFLetter extends AbstractWriteLetter{

	
	public PDFLetter(List<CitizenDB> citizens,String message) {
		super(citizens,message);
		for(CitizenDB citizen : citizens){
			try {
				this.write(citizen);
			} catch (FileNotFoundException e) {
				System.err.println("Error al crear la carta: "+citizen.getName()+".pdf");
			}
		}
	}

	/**
	 * Sobreescritura del método write para escribir la carta 
	 * al usuario en formato PDF
	 * @throws FileNotFoundException en caso de que no exista el fichero
	 */
	@Override
	public void write(CitizenDB citizenDB) throws FileNotFoundException{
		Document document = new Document();
		FileOutputStream pdfFile;
		try {
			pdfFile = new FileOutputStream(this.getPath()+"PDF/"+citizenDB.getName()+".pdf");
			PdfWriter.getInstance(document, pdfFile).setInitialLeading(20);
			document.open();
			document.add(new Paragraph("Estimado "+citizenDB.getName()));
			document.add(new Paragraph(this.message));
			document.add(new Paragraph("Usuario: "+citizenDB.getMail()));
			document.add(new Paragraph("Contraseña: "+citizenDB.getPassword()));
			document.close();
		}  catch (DocumentException e) {
			System.out.println("Error al crear el documento: "+citizenDB.getName()+".pdf");
			e.printStackTrace();
		}
	}
}
