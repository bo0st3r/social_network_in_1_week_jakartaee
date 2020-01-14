package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.OfferDAO;
import be.helha.aemt.entity.InternshipOffer;
import be.helha.aemt.entity.JobOffer;
import be.helha.aemt.entity.Offer;

@Stateless
public class OfferManagerEJB {
	@EJB
	private OfferDAO dao;
	
	public List<Offer> queryAll(){
		return dao.queryAll();
	}
	
	public List<Offer> queryJob(){
		return dao.queryType(JobOffer.class.getSimpleName());
	}
	
	public List<Offer> queryInternship(){
		return dao.queryType(InternshipOffer.class.getSimpleName());
	}
	
	public Offer queryById(int id) {
		return dao.queryById(id);
	}
	
	public int queryIdFromEquals(Offer offer) {
		return dao.queryIdFromEquals(offer);
	}
	
	public Offer post(Offer offer) {
		return dao.post(offer);
	}
	
	public boolean update(Offer offer) {
		return dao.update(offer);
	}
	
	public boolean deleteById(int id) {
		return dao.deleteById(id);
	}
}
