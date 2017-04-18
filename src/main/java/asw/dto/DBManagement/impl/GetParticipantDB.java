package asw.dto.DBManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asw.dto.DBManagement.GetParticipant;
import asw.dto.DBManagement.model.Ciudadano;
import asw.dto.DBManagement.persistence.CiudadanoRepository;
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
