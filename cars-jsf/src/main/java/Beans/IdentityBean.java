package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import domain.Admin;
import domain.Customer;

@ManagedBean(name = "identity")
@SessionScoped
public class IdentityBean {

	private Object identifiedUser;

	public IdentityBean() {
	}

	public Object getIdentifiedUser() {
		return identifiedUser;
	}

	public void setIdentifiedUser(Object identifiedUser) {
		this.identifiedUser = identifiedUser;
	}

	public Boolean hasRole(String role) {
		Boolean response = false;
		switch (role) {
		case "Admin":
			response = identifiedUser instanceof Admin;
			break;
		case "Customer":
			response = identifiedUser instanceof Customer;
			break;
		}
		return response;
	}
}
