package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.News;
import be.helha.aemt.helper.Config;

@Stateless
@LocalBean
public class NewsDAO {
	@PersistenceContext(unitName = Config.UNIT_NAME)
	private EntityManager em;
	
	public List<News> queryAll(){
		return em.createNamedQuery("News.queryAll").getResultList();
	}
	
	public List<News> queryAmount(int amount){
		Query query = em.createNamedQuery("News.queryAmount");
		query.setParameter("amount", amount);
		return query.getResultList();
	}
	
	public News queryById(int id) {
		Query query = em.createNamedQuery("News.queryById");
		query.setParameter("id", id);
		
		List<News> results = query.getResultList();
		if(results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
	
	public int queryIdFromEquals(News news) {
		Query query = em.createNamedQuery("News.queryIdFromEquals");
		query.setParameter("name", news.getName());
		query.setParameter("postingDate", news.getPostingDate());
		
		List<Integer> results = query.getResultList();
		if(results.size() > 0)
		{
			return results.get(0);
		}
		return -1;
	}
	
	public News post(News news) {
		news.setIdNews(queryIdFromEquals(news));
		
		em.persist(news);
		return news;
	}
	
	public boolean update(News news) {
		News updated = queryById(news.getIdNews());
		if(updated != null) {
			updated.setName(news.getName());
			updated.setDescription(news.getDescription());
			updated.setPostingDate(news.getPostingDate());
			updated.setPicture(news.getPicture());
			
			updated = em.merge(updated);
			
			return news.equals(updated);
		}
		
		return false;
	}
	
	public boolean delete(News news) {
		em.remove(news);
		
		return queryIdFromEquals(news) == -1;
	}
}
