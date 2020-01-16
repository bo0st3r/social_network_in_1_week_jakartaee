package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.InternshipOffer;
import be.helha.aemt.entity.JobOffer;
import be.helha.aemt.entity.Offer;
import be.helha.aemt.helper.Config;

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
		Query query = em.createNamedQuery("Offer.queryAll");
		if(className.equals(JobOffer.class.getSimpleName())) {
			query = em.createNamedQuery("Offer.queryJob");
		}else if(className.equals(InternshipOffer.class.getSimpleName())) {
			query = em.createNamedQuery("Offer.queryInternship");
		}
		
		return query.getResultList();
	}
	
	public long queryTypeAmountToApprove(String className){
		if(className.equals(JobOffer.class.getSimpleName())) {
			Query query = em.createNamedQuery("Offer.queryJobAmountToApprove");
			return (long) query.getResultList().get(0);
		}else if(className.equals(InternshipOffer.class.getSimpleName())) {
			Query query = em.createNamedQuery("Offer.queryInternshipAmountToApprove");
			return (long) query.getResultList().get(0);
		}
		return -1;
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
		Offer updated = queryById(offer.getIdOffer());
		
		if(updated != null) {
			if(offer instanceof JobOffer) {
				JobOffer job = (JobOffer)updated;
				job.setContractType(((JobOffer) offer).getContractType());
			}else if(offer instanceof InternshipOffer) {
				InternshipOffer intern = (InternshipOffer)offer;
				intern.setDuration(((InternshipOffer) offer).getDuration());
				intern.setThesisPossibility(((InternshipOffer) offer).isThesisPossibility());
			}
			
			updated.setLabelOffer(offer.getLabelOffer());
			updated.setCompanyName(offer.getCompanyName());
			updated.setDescriptionOffer(offer.getDescriptionOffer());
			updated.setPostingDate(offer.getPostingDate());
			updated.setStartingDate(offer.getStartingDate());
			updated.setMajor(offer.getMajor());
			updated.setApproved(offer.isApproved());
			
			offer.setAddress(addressDao.post(offer.getAddress()));
			updated.setAddress(offer.getAddress());
			
			updated = em.merge(updated);
			return offer.equals(updated);
		}
		return false;
	}
	
	public boolean delete(Offer offer) {
		em.remove(offer);
		
		return queryIdFromEquals(offer) == -1;
	}
	
}
