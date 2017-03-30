package participants;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ParticipantsLogin")
public class ParticipantsLogin {

	
	private String password;
	private String email;
	
	public ParticipantsLogin() {
	
	}
	public ParticipantsLogin(String email,String password) {
		this.email = email;
		this.password = password;
	}

	@XmlElement
	public String getPassword() {
		return password;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "ParticipantsLogin [password=" + password + ", email=" + email + "]";
	}
	
	
	
	
}
