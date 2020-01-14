package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.News;
import be.helha.aemt.helper.Config;

@NamedQuery(name="News.queryAll", query="SELECT n FROM News n ORDER BY n.postingDate ASC")
@NamedQuery(name="News.queryAmount", query="SELECT n FROM News n ORDER BY n.postingDate ASC LIMIT :amount")
@NamedQuery(name="News.queryById", query="SELECT n FROM News n WHERE n.idNews = :id")
@NamedQuery(name="News.queryIdFromEquals", query="SELECT n.idNews FROM News n "
		+ "WHERE n.name = :name AND n.postingDate = :date")

@NamedQuery(name="News.update", query="UPDATE News n "
		+ "SET n.name = :name AND n.description = :description AND n.postingDate = :date "
		+ "WHERE n.idNews = :id")

@NamedQuery(name="News.deleteById", query="DELETE FROM News n WHERE n.idNews = :id")

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
	
	public News QueryById(int id) {
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
		Query query = em.createNamedQuery("News.update");
		query.setParameter("name", news.getName());
		query.setParameter("description", news.getDescription());
		query.setParameter("postingDate", news.getPostingDate());
		query.setParameter("id", news.getIdNews());
		
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public boolean deleteById(int id) {
		Query query = em.createNamedQuery("News.deleteById");
		query.setParameter("id", id);
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
}
