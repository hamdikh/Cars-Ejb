package beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.esprit.entities.Organizer;
import edu.esprit.entities.Participant;
import edu.esprit.entities.User;
import edu.esprit.interfaces.UserServiceLocal;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String password;
	@ManagedProperty("#{identity}")
	IdentityBean identityBean;
	@EJB
	private UserServiceLocal userServicesLocal;

	public String doLogin() {
		String navigateTo = null;
		User found = userServicesLocal.authenticate(login, password);
		if (found != null) {
			identityBean.setIdentifiedUser(found);
			if (found instanceof Organizer) {
				navigateTo = "/organizer/home?faces-redirect=true";
			} else if (found instanceof Participant) {
				navigateTo = "/participant/home?faces-redirect=true";
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
