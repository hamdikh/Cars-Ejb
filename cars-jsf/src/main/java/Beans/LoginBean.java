package Beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import services.interfaces.UserServicesLocal;
import domain.Admin;
import domain.Customer;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String password;
	@ManagedProperty("#{identity}")
	IdentityBean identityBean;
	@EJB
	private UserServicesLocal userServicesLocal;

	public String doLogin() {
		String navigateTo = null;
		Object found = userServicesLocal.login(login, password);
		if (found != null) {
			identityBean.setIdentifiedUser(found);
			if (found instanceof Admin) {
				navigateTo = "/admin/home?faces-redirect=true";
			} else if (found instanceof Customer) {
				navigateTo = "/customer/home?faces-redirect=true";
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"NON AUTORISE", null

					));
		}
		return navigateTo;
	}

	public String doLogout() {
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.clear();
		navigateTo = "/login?faces-redirect=true";
		return navigateTo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IdentityBean getIdentityBean() {
		return identityBean;
	}

	public void setIdentityBean(IdentityBean identityBean) {
		this.identityBean = identityBean;
	}

}
