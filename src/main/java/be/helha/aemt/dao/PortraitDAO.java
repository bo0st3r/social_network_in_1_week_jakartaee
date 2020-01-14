package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.News;
import be.helha.aemt.entity.Portrait;
import be.helha.aemt.helper.Config;

@NamedQuery(name="Portrait.queryAll", query="SELECT p FROM Portrait p")
@NamedQuery(name="Portrait.queryById", query="SELECT p FROM Portrait p WHERE p.idPortrait = :id")
@NamedQuery(name="Portrait.queryIdFromEquals", query="SELECT p .idPortrait FROM Portrait p WHERE p.label = :label")

@NamedQuery(name="Portrait.update", query="UPDATE Portrait p "
		+ "SET p.label = :label AND p.content = :content "
		+ "WHERE p.idPortrait = :id")

@NamedQuery(name="Portrait.deleteById", query="DELETE FROM Portrait p WHERE p.idPortrait = :id")

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
		Query query = em.createNamedQuery("Portrait.update");
		query.setParameter("label", portrait.getLabel());
		query.setParameter("content", portrait.getContent());
		query.setParameter("id", portrait.getIdPortrait());
		
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		Query query = em.createNamedQuery("Portrait.deleteById");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
}
