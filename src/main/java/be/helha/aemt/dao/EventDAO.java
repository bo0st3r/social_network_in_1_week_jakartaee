package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.Address;
import be.helha.aemt.entity.Event;
import be.helha.aemt.helper.Config;

@Stateless
@LocalBean
public class EventDAO {
	@PersistenceContext(unitName = Config.UNIT_NAME)
	private EntityManager em;
	private AddressDAO addressDao;
	
	public List<Event> queryAll(){
		return em.createNamedQuery("Event.queryAll").getResultList();
	}
	
	public Event queryById(int id) {
		Query query = em.createNamedQuery("Event.queryById");
		query.setParameter("id", id);
		List<Event> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}else {
			return null;
		}
	}
	
	public Event queryEquals(Event event) {
		Query query = em.createNamedQuery("Event.queryEquals");
		query.setParameter("label", event.getLabelEvent());
		query.setParameter("date", event.getDateEvent());
		List<Event> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}else {
			return null;
		}
	}
	
	public int queryIdFromEquals(Event event) {
		Query query = em.createNamedQuery("Event.queryIdFromEquals");
		query.setParameter("label", event.getLabelEvent());
		query.setParameter("date", event.getDateEvent());
		List<Integer> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}else {
			return -1;
		}
	}
	
	public Event post(Event event) {
		event.setIdEvent(queryIdFromEquals(event));
		event.getAddressEvent().setId(addressDao.queryIdFromEquals(event.getAddressEvent()));;
		
		em.persist(event);
		
		return event;
	}
	
	public boolean update(Event event) {
		Event updated = queryById(event.getIdEvent());
		if(updated != null) {
			updated.setLabelEvent(event.getLabelEvent());
			updated.setDateEvent(event.getDateEvent());
			updated.setDescriptionEvent(event.getDescriptionEvent());
			updated.setImageEvent(event.getImageEvent());
			updated.setApproved(event.isApproved());	
			
			addressDao.post(event.getAddressEvent());
			Address address = addressDao.queryEquals(event.getAddressEvent());
			
			updated.setAddressEvent(address);
			updated = em.merge(updated);
			
			return event.equals(updated);
		}
		return false;
	}
	
	public boolean delete(Event event) {
		em.remove(event);
		
		return queryIdFromEquals(event) == -1;
	}

}
