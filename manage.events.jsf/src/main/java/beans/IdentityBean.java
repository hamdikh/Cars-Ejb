package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.esprit.entities.Organizer;
import edu.esprit.entities.Participant;
import edu.esprit.entities.User;

@ManagedBean(name = "identity")
@SessionScoped
public class IdentityBean {

	private User identifiedUser;

	public IdentityBean() {
	}

	public Object getIdentifiedUser() {
		return identifiedUser;
	}

	public void setIdentifiedUser(User identifiedUser) {
		this.identifiedUser = identifiedUser;
	}

	public Boolean hasRole(String role) {
		Boolean response = false;
		switch (role) {
		case "Organizer":
			response = identifiedUser instanceof Organizer;
			break;
		case "Participant":
			response = identifiedUser instanceof Participant;
			break;
		}
		return response;
	}

}
