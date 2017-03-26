package DBManagement;

import model.Ciudadano;
import participants.ParticipantsLogin;

/**
 * 
 * @author Pablo
 *
 */

public interface GetParticipant{
	public Ciudadano getCiudadano(String email);
	public Ciudadano getCiudadano(ParticipantsLogin participante);
}
