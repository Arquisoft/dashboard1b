package asw.DBManagement_original;

import asw.DBManagement_original.model.Ciudadano;
import asw.participants_original.acceso.ParticipantsLogin;

/**
 * 
 * @author Pablo
 *
 */

public interface GetParticipant{
	public Ciudadano getCiudadano(String email);
	public Ciudadano getCiudadano(ParticipantsLogin participante);
}
