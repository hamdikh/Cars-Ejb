package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import edu.esprit.entities.Event;
import edu.esprit.entities.Participant;
import edu.esprit.entities.Reservation;
import edu.esprit.interfaces.EventServiceLocal;
import edu.esprit.interfaces.ReservationServiceLocal;

@ManagedBean
@ViewScoped
public class ReservationBean {

	private Reservation reservation;
	private Event event;
	private List<Event> events;
	@ManagedProperty("#{identity.identifiedUser}")
	private Participant participant;
	private List<Participant> participants;
	@EJB
	private ReservationServiceLocal reservationServiceLocal;
	@EJB
	private EventServiceLocal eventServiceLocal;

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	@PostConstruct
	public void initModel() {
		participants = new ArrayList();
		reservation = new Reservation();
		event = new Event();
		setEvents(eventServiceLocal.findAllEvnets());
	}

	public void doSave() {
		reservationServiceLocal.addReservation(reservation);
	}

	public void doParticipate() {

		participants.add(participant);
		event.setParticipants(participants);
		reservation.setEvent(event);
		doSave();
		// eventServiceLocal.updateEvent(event);
		// doSave();
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

}
