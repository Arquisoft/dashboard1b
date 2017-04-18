package es.uniovi.asw.letters;

import es.uniovi.asw.CitizenDB;
import java.io.IOException;
import java.util.List;

public abstract class AbstractWriteLetter implements WriteLetter {

	protected List<CitizenDB> citizens;
	protected String message;
	protected String path = "src/main/resources/letters/";
	
	public AbstractWriteLetter(List<CitizenDB> citizens,String message){
		this.citizens = citizens;
		this.message = message;
	}

	public void setMessage(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public String getPath(){
		return this.path;
	}
	
	@Override
	public abstract void write(CitizenDB citizenDB) throws IOException;
}
