package es.uniovi.asw.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.CitizenDB;


/**
 * Clase implementada a modo de adaptador
 * para la librería apache Poi
 * Desacopla a la clase RListExcel del tipo
 * de librería que usemos para leer el fichero
 * @author david
 *
 */
public class AdapterPoi {
	
	private XSSFWorkbook workbook;

	/**
	 * Constructor del archivo de entrada
	 * y el libro de excel
	 * @param path Ruta de acceso al fichero
	 * @throws FileNotFoundException en caso de que no exista el fichero a ejecutar
	 */
	public AdapterPoi(String path) throws FileNotFoundException {
			FileInputStream file = new FileInputStream(new File(path));
			try {
				this.workbook = new XSSFWorkbook(file);
			} catch (IOException e) {
				System.err.println("Error entrada/salida");
			}
	}
	
	
	/**
	 * Método que se encarga de leer el libro de excel
	 * cuya ruta recibimos en el constructor y devuelve una lista 
	 * de ciudadanos
	 * @return lista de Usuarios de la base de datos
	 */
	public List<CitizenDB> readExcelFile(){
		List<CitizenDB> citizens = new ArrayList<CitizenDB>(); 
		// para cada una de las hojas presentes en el documento de excel
		for(int i=0;i < workbook.getNumberOfSheets();i++){
			XSSFSheet sheet = this.workbook.getSheetAt(i);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row;
			int counter = 0;
			//para cada fila de la hoja
			while(rowIterator.hasNext()){
				row = rowIterator.next();
				if (counter > 0) { //omitimos la cabecera (hay que mirar si hay un metodo de la API)
					Iterator<Cell> cellIterator = row.cellIterator();
					int j = 0;
					CitizenDB user = new CitizenDB();
					while (cellIterator.hasNext()) 	
						this.insertCitizenField(user, j++, cellIterator.next());	
					user.setPassword(new GenerationPassword().passwordGenerator());
					citizens.add(user);
				}
				counter++;
			}
		}
		return citizens;
	}
	
	/**
	 * En función de la columna del excel leída, insertaremos un valor u otro
	 * en el cliente
	 * @param citizen
	 * @param col columna en la que se encuentra la celda a tratar
	 * @param cell La celda a tratar en cada momento
	 */
	private void insertCitizenField(CitizenDB citizen, int col,Cell cell) {
		switch(col){
		case 0:
			citizen.setName(cell.getStringCellValue());
			return;
		case 1:
			citizen.setSurname(cell.getStringCellValue());
			return;
		case 2:
			citizen.setMail(cell.getStringCellValue());
			return;
		case 3:
			citizen.setBirthday(cell.getDateCellValue());
			return;
		case 4:
			citizen.setAddress(cell.getStringCellValue());
			return;
		case 5:
			citizen.setNationality(cell.getStringCellValue());
			return;
		case 6:
			citizen.setDNI(cell.getStringCellValue());
			return;
		default:
			return;
		}
	}
}
