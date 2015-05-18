package beans;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.esprit.entities.CategoryEvent;
import edu.esprit.entities.Event;
import edu.esprit.entities.Organizer;
import edu.esprit.interfaces.CategoryEventServiceLocal;
import edu.esprit.interfaces.EventServiceLocal;

@ManagedBean
@ViewScoped
public class EventBean {

	private Event event;
	private CategoryEvent categoryEvent;
	private List<CategoryEvent> categoryEvents;
	@ManagedProperty("#{identity.identifiedUser}")
	private Organizer organizer;
	@EJB
	private EventServiceLocal eventServiceLocal;

	@EJB
	private CategoryEventServiceLocal categoryEventServiceLocal;

	@PostConstruct
	public void initModel() {
		event = new Event();
		categoryEvent = new CategoryEvent();
		categoryEvents = categoryEventServiceLocal.findAllCategoryEvents();
	}

	public void doSave() {
		event.setOrganizer(organizer);
		event.setDate(new Date());
		eventServiceLocal.addEvent(event);
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public CategoryEvent getCategoryEvent() {
		return categoryEvent;
	}

	public void setCategoryEvent(CategoryEvent categoryEvent) {
		this.categoryEvent = categoryEvent;
	}

	public List<CategoryEvent> getCategoryEvents() {
		return categoryEvents;
	}

	public void setCategoryEvents(List<CategoryEvent> categoryEvents) {
		this.categoryEvents = categoryEvents;
	}

}
