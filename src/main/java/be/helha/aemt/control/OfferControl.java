package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.OfferManagerEJB;
import be.helha.aemt.entity.InternshipOffer;
import be.helha.aemt.entity.JobOffer;
import be.helha.aemt.entity.Offer;

@SessionScoped
@Named
public class OfferControl implements Serializable {
	private static final long serialVersionUID = 8483914017523360658L;

	@EJB
	private OfferManagerEJB gestion;
	
	private Offer offer = new Offer();
	private JobOffer job = new JobOffer();
	private InternshipOffer intern = new InternshipOffer();
	
	public List<Offer> queryAll(){
		return gestion.queryAll();
	}
	
	public List<JobOffer> queryJob(){
		List<JobOffer> results = new ArrayList<JobOffer>();
		
		for (Offer offer : gestion.queryJob()) {
			if(offer instanceof JobOffer)
				results.add((JobOffer) offer);
		}
		
		return results;
	}
	
	public List<InternshipOffer> queryInternship(){
		List<InternshipOffer> results = new ArrayList<InternshipOffer>();
		
		for (Offer offer : gestion.queryInternship()) {
			if(offer instanceof InternshipOffer)
				results.add((InternshipOffer) offer);
		}
		
		return results;
	}
	
	public Offer queryById(int id) {
		offer = gestion.queryById(id);
		if(offer instanceof JobOffer) {
			job = (JobOffer) offer;
		}else if(offer instanceof InternshipOffer) {
			intern = (InternshipOffer) offer;
		}
		return offer;
	}

	public int queryIdFromEquals(Offer offer) {
		return gestion.queryIdFromEquals(offer);
	}

	public int queryIdFromEquals() {
		return gestion.queryIdFromEquals(offer);
	}

	public boolean update(Offer offer) {
		return gestion.update(offer);
	}

	public boolean update() {
		return gestion.update(offer);
	}

	public boolean delete(Offer offer) {
		return gestion.delete(offer);
	}

	public boolean delete() {
		return gestion.delete(offer);
	}

	/*****************************
		   Getters & setters
	*****************************/
	
	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public JobOffer getJob() {
		return job;
	}

	public void setJob(JobOffer job) {
		this.job = job;
	}

	public InternshipOffer getIntern() {
		return intern;
	}

	public void setIntern(InternshipOffer intern) {
		this.intern = intern;
	}
	
}
