package es.uniovi.asw.dbupdate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import es.uniovi.asw.CitizenDB;
import es.uniovi.asw.parser.CheckCitizen;
import es.uniovi.asw.parser.GenerationPassword;

/**
 * 
 * @author oliver
 */
public class InsertP implements Insert{

	private CheckCitizen checkCitizen = new CheckCitizen();
	private GenerationPassword generationPassword = new GenerationPassword();
	
	@Override
	public List<CitizenDB> insert(List<CitizenDB> citizens) throws SQLException {
		EntityManager em = Jpa.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		trx.begin();
		List<CitizenDB> users = new ArrayList<CitizenDB>();
		try{
			
			for(CitizenDB citizen : citizens)
				if(checkCitizen.checkCitizenInformation(citizen) && checkCitizen(citizen)){
					citizen.setPassword(generationPassword.passwordGenerator());
					Jpa.getManager().persist(citizen);
					users.add(citizen);
				}
	    
		trx.commit();	    
		}catch(RuntimeException e){
			trx.rollback();
	    	throw e;
		}
		finally{
			em.close();
		}
		return users;
	}

	/**Metodo que se encarga de comprobar si un ciudano ya existe en la base de datos
	 * @param citizen: ciudadano que queremos comprobar
	 * @return devuelve true si no esta y false si esta
	 */
	private boolean checkCitizen(CitizenDB citizen) {

		Query query = Jpa.getManager().createQuery("select c from CitizenDB c where c.DNI = ?1");
		query.setParameter(1 , citizen.getDNI());
		if(!query.getResultList().isEmpty()){
			//Una vez hecho el logo aqui iria reporter.write(informacion que tenemos que meter en el log);
			return false;
		}
		return true;
		
	}
}
