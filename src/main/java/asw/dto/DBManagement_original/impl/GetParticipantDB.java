package asw.dto.DBManagement_original.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asw.DBManagement_original.GetParticipant;
import asw.DBManagement_original.model.Ciudadano;
import asw.DBManagement_original.persistence.CiudadanoRepository;
import asw.participants_original.acceso.ParticipantsLogin;

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
