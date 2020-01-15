package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.NewsDAO;
import be.helha.aemt.entity.News;

@Stateless
public class NewsManagerEJB {
	@EJB
	private NewsDAO dao;
	
	public List<News> queryAll(){
		return dao.queryAll();
	}
	
	public News queryById(int id) {
		return dao.queryById(id);
	}
	
	public int queryIdFromEquals(News news) {
		return dao.queryIdFromEquals(news);
	}
	
	public News post(News news) {
		return dao.post(news);
	}
	
	public boolean update(News news) {
		return dao.update(news);
	}
	
	public boolean delete(News news) {
		return dao.delete(news);
	}
}
