package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.Portrait;
import be.helha.aemt.helper.Config;

@Stateless
@LocalBean
public class PortraitDAO {
	@PersistenceContext(unitName = Config.UNIT_NAME)
	private EntityManager em;
	
	public List<Portrait> queryAll(){
		return em.createNamedQuery("Portrait.queryAll").getResultList();
	}
	
	public Portrait queryById(int id) {
		Query query = em.createNamedQuery("Portrait.queryById");
		query.setParameter("id", id);
		
		List<Portrait> results = query.getResultList();
		if(results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
	public int queryIdFromEquals(Portrait portrait) {
		Query query = em.createNamedQuery("Portrait.queryIdFromEquals");
		query.setParameter("intitule", portrait.getLabel());
		
		List<Integer> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}
		return -1;
	}
	
	public Portrait post(Portrait portrait) {
		portrait.setIdPortrait(queryIdFromEquals(portrait));
		
		em.persist(portrait);
		return portrait;
	}
	
	public boolean update(Portrait portrait) {
		Portrait updated = queryById(portrait.getIdPortrait());
		
		if(updated != null) {
			updated.setLabel(portrait.getLabel());
			updated.setContent(portrait.getContent());
			
			updated = em.merge(updated);
			
			return portrait.equals(updated);
		}
		
		return false;
	}
	
	public boolean delete(Portrait portrait) {
		em.remove(portrait);
			
		return queryIdFromEquals(portrait) == -1;
		
	}
	
}
