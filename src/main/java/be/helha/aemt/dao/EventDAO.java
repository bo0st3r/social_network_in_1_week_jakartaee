package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.Address;
import be.helha.aemt.entity.Event;

@NamedQuery(name="Event.queryAll", query="SELECT e FROM Event e")
@NamedQuery(name="Event.queryById", query="SELECT e FROM Event e WHERE e.idEvent = :id")
@NamedQuery(name="Event.queryEquals", query="SELECT e FROM Event e WHERE e.labelEvent = :label AND e.dateEvent = :date")
@NamedQuery(name="Event.queryIdFromEquals", query="SELECT e.idEvent FROM Event e WHERE e.labelEvent = :label AND e.dateEvent = :date")

@NamedQuery(name="Event.update", query="UPDATE Event e "
		+ "SET e.labelEvent = :label AND e.dateEvent = :date AND e.descriptionEvent = :description AND e.imageEvent = :image AND e.address = :address"
		+ "WHERE e.idEvent = :id")

@NamedQuery(name="Event.deleteById", query="DELETE FROM Event e WHERE e.idEvent = :id")

@Stateless
@LocalBean
public class EventDAO {
	@PersistenceContext(unitName = "groupeB4JTA")
	private EntityManager em;
	private EntityTransaction tx;
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
		
		tx.begin();
		em.persist(event);
		tx.commit();
		
		return event;
	}
	
	public boolean update(Event event) {
		Query query = em.createNamedQuery("Event.update");
		query.setParameter("label", event.getLabelEvent());
		query.setParameter("date", event.getDateEvent());
		query.setParameter("description", event.getDescriptionEvent());
		query.setParameter("image", event.getImageEvent());
		query.setParameter("id", event.getIdEvent());
	
		addressDao.post(event.getAddressEvent());
		Address adress = addressDao.queryEquals(event.getAddressEvent());
		
		query.setParameter("address", adress.getId());
		
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		Query query = em.createNamedQuery("Event.deleteById");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}

}
