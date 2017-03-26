package impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import DBManagement.GetParticipant;
import model.Ciudadano;
import persistence.CiudadanoRepository;
import participants.ParticipantsLogin;

@Component
public class GetParticipantDB implements GetParticipant{

	@Autowired
	private CiudadanoRepository repositorio; 
	
	@Override
	public Ciudadano getCiudadano(String email) {
		Ciudadano citizen = repositorio.findByEmail(email);
		return citizen;
	}

	@Override
	public Ciudadano getCiudadano(ParticipantsLogin participante) {
		Ciudadano citizen = repositorio.findByEmail(participante.getEmail());
		return citizen;
	}


}
