package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.esprit.entities.Venue;
import edu.esprit.interfaces.VenueServiceLocal;

@ManagedBean
@ViewScoped
public class VenueBean {

	private Venue venue;
	@EJB
	VenueServiceLocal venueServiceLocal;

	@PostConstruct
	public void initModel() {
		venue = new Venue();
	}

	public String doSave() {
		venueServiceLocal.addVenue(venue);
		return "";
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
