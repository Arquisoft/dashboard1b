package persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import model.Ciudadano;

@Component
public class DatabaseLoader {

	@Autowired
	private CiudadanoRepository repository;
	
	
	@PostConstruct
	 private void initDatabase() throws ParseException {
		
		Ciudadano c1 = new Ciudadano("Ramon", "Sobrino Llorca", "ramonsobrino@llorca.es",
				new SimpleDateFormat("yyyy-MM-dd").parse("1990-02-02"), "Oviedo", "Española", "71664900", "123456", true);
		Ciudadano c2 = new Ciudadano("Pablo", "Garcia", "pablo@gmail.es",
				new SimpleDateFormat("yyyy-MM-dd").parse("1995-10-31"), "Oviedo", "Española", "79845632", "111111", false);
		Ciudadano c3 = new Ciudadano("Javier", "Fernandez", "javivaldu@gmail.es",
				new SimpleDateFormat("yyyy-MM-dd").parse("1992-02-02"), "Oviedo", "Española", "78945612", "999999", false);
		Ciudadano c4 = new Ciudadano("Benjy", "Rojas", "benjy@gmail.es",
				new SimpleDateFormat("yyyy-MM-dd").parse("1993-02-02"), "Oviedo", "Española", "78945612", "222222", false);
		repository.save(c1);
		repository.save(c2);
		repository.save(c3);
		repository.save(c4);
	}
}
