package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;
import be.helha.aemt.entity.Event;

@Stateless
public class EventManagerEJB {
	@EJB
	private EventDAO dao;
	
	public List<Event> queryAll(){
		return dao.queryAll();
	}
	
	public Event quesryById(int id) {
		return dao.queryById(id);
	}
	
	public Event queryEquals(Event event) {
		return dao.queryEquals(event);
	}
	
	public int queryIdFromEquals(Event event) {
		return dao.queryIdFromEquals(event);
	}
	
	public Event post(Event event) {
		return dao.post(event);
	}
	
	public boolean update(Event event) {
		return dao.update(event);
	}
	
	public boolean deleteById(int id) {
		return dao.deleteById(id);
	}
}
