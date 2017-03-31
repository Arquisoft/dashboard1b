package asw.DBManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asw.DBManagement.GetParticipant;
import asw.DBManagement.model.Ciudadano;
import asw.DBManagement.persistence.CiudadanoRepository;
import asw.participants.acceso.ParticipantsLogin;

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
