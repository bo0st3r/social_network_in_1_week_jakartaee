package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.EventManagerEJB;
import be.helha.aemt.entity.Event;

@SessionScoped
@Named
public class EventControl implements Serializable {
	private static final long serialVersionUID = -7120088471496101019L;
	
	@EJB
	private EventManagerEJB gestion;
	
	private Event event = new Event();
	
	public Event post() {
		return gestion.post(event);
	}
	
	public List<Event> queryAll(){
		return gestion.queryAll();
	}
	
	public Event queryById(int id) {
		event = gestion.queryById(id);
		return event;
	}

	public Event queryEquals(Event event) {
		this.event = gestion.queryEquals(event);
		return this.event;
	}

	public Event queryEquals() {
		this.event = gestion.queryEquals(event);
		return this.event;
	}

	public int queryIdFromEquals(Event event) {
		return gestion.queryIdFromEquals(event);
	}

	public int queryIdFromEquals() {
		return gestion.queryIdFromEquals(event);
	}
	
	public boolean update() {
		return gestion.update(event);
	}
	
	public boolean delete() {
		return gestion.delete(event);
	}

	/*****************************
	   Getters & setters
	 *****************************/

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	
}
