package asw.DBManagement;

import asw.DBManagement.model.Ciudadano;
import asw.participants.acceso.ParticipantsLogin;

/**
 * 
 * @author Pablo
 *
 */

public interface GetParticipant{
	public Ciudadano getCiudadano(String email);
	public Ciudadano getCiudadano(ParticipantsLogin participante);
}
