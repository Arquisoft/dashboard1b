package asw.dto.DBManagement_original.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import asw.dto.DBManagement_original.GetParticipant;
import asw.dto.DBManagement_original.model.Ciudadano;
import asw.dto.DBManagement_original.persistence.CiudadanoRepository;

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
