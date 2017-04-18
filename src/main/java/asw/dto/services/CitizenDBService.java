package asw.services;

import asw.model.CitizenDB;

public interface CitizenDBService {

	public CitizenDB getByLogin(String login);
	public CitizenDB getCitizenDB(String email);
	public CitizenDB createCitizenDB(CitizenDB citizenDB);
}
