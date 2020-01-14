package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.InternshipOffer;
import be.helha.aemt.entity.JobOffer;
import be.helha.aemt.entity.Offer;
import be.helha.aemt.helper.Config;

@NamedQuery(name="Offer.queryAll", query="SELECT o FROM Offer o ORDER BY o.postingDate ASC") 
@NamedQuery(name="Offer.queryType", query="SELECT o FROM Offer o WHERE o.dtype LIKE :type ORDER BY o.postingDate ASC")
@NamedQuery(name="Offer.queryById", query="SELECT o FROM Offer o WHERE o.idOffer = :id")
@NamedQuery(name="Offer.queryIdFromEquals", query="SELECT o.idOffer FROM Offer o WHERE o.labelOffer = :label AND o.companyName = :company AND o.postingDate = :date")

@NamedQuery(name="Offer.updateOffer", query="UPDATE Offer o "
		+ "SET o.labelOffer = :label AND o.companyName = :company AND o.descriptionOffer = :description AND o.startingDate = :sDate "
		+ "AND o.postingDate = :pDate AND o.major = :major AND o.approved = :approved AND o.address = :address "
		+ "WHERE o.idOffer = :id")

@NamedQuery(name="Offer.updateJobOffer", query="UPDATE Offer o "
		+ "SET o.labelOffer = :label AND o.companyName = :company AND o.descriptionOffer = :description AND o.startingDate = :sDate "
		+ "AND o.postingDate = :pDate AND o.contractType = :contract AND o.salary = :salary "
		+ "AND o.major = :major AND o.approved = :approved  AND o.address = :address "
		+ "WHERE o.idOffer = :id")
@NamedQuery(name="Offer.updateIntershipOffer", query="UPDATE Offer o "
		+ "SET o.labelOffer = :label AND o.companyName = :company AND o.descriptionOffer = :description AND o.startingDate = :sDate "
		+ "AND o.postingDate = :pDate AND o.major = :major AND o.approved = :approved  AND o.address = :address "
		+ "AND o.duration = :duration AND o.thesisPossibility = :thesis "
		+ "WHERE o.idOffer = :id")


@NamedQuery(name="Offer.deleteById", query="DELETE FROM Offer o WHERE o.idOffer = :id")

@Stateless
@LocalBean
public class OfferDAO {
	@PersistenceContext(unitName = Config.UNIT_NAME)
	private EntityManager em;
	private AddressDAO addressDao = new AddressDAO();
	
	public List<Offer> queryAll(){
		return em.createNamedQuery("Offer.queryAll").getResultList();
	}
	
	public List<Offer> queryType(String className){
		Query query = em.createNamedQuery("Offer.queryType");
		query.setParameter("type", className);
		return query.getResultList();
	}
	
	public Offer queryById(int id) {
		Query query = em.createNamedQuery("Offer.queryById");
		query.setParameter("id", id);
		
		List<Offer> results = query.getResultList();
		if(results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
	public int queryIdFromEquals(Offer offer) {
		Query query = em.createNamedQuery("Offer.queryIdFromEquals");
		query.setParameter("label", offer.getLabelOffer());
		query.setParameter("company", offer.getCompanyName());
		query.setParameter("date", offer.getPostingDate());
		
		List<Integer> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}
		return -1;
	}
	
	public Offer post(Offer offer) {
		offer.setIdOffer(queryIdFromEquals(offer));
		offer.getAddress().setId(addressDao.queryIdFromEquals(offer.getAddress()));
		
		em.persist(offer);
		
		return offer;
	}
	
	public boolean update(Offer offer) {
		Query query = em.createNamedQuery("Offer.updateOffer");
		if(offer instanceof JobOffer) {
			JobOffer job = (JobOffer)offer;
			query = em.createNamedQuery("Offer.updateJobOffer");
			query.setParameter("contract", job.getContractType());
			query.setParameter("salary", job.getSalary());
		}else if(offer instanceof InternshipOffer) {
			InternshipOffer intern = (InternshipOffer)offer;
			query = em.createNamedQuery("Offer.updateInternshipOffer");
			query.setParameter("duration", intern.getDuration());
			query.setParameter("thesis", intern.isThesisPossibility());
		}
		
		query.setParameter("label", offer.getLabelOffer());
		query.setParameter("company", offer.getCompanyName());
		query.setParameter("description", offer.getDescriptionOffer());
		query.setParameter("pDate", offer.getPostingDate());
		query.setParameter("sDate", offer.getStartingDate());
		query.setParameter("major", offer.getMajor());
		query.setParameter("approved", offer.isApproved());
		
		offer.setAddress(addressDao.post(offer.getAddress()));
		query.setParameter("address", offer.getAddress().getId());
		
		query.setParameter("id", offer.getIdOffer());
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		Query query = em.createNamedQuery("Offer.deleteById");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
}
