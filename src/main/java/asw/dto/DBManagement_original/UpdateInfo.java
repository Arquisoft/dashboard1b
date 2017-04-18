package asw.DBManagement_original;

import asw.DBManagement_original.model.Ciudadano;
import asw.participants_original.acceso.ChangePassword;

/**
 * 
 * @author Ramon Sobrino Llorca
 *
 */
public interface UpdateInfo{

	public boolean UpdateCitizen(Ciudadano ciudadano);
	public Ciudadano UpdateCitizen(ChangePassword info);
}
