package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.NewsManagerEJB;
import be.helha.aemt.entity.News;

@SessionScoped
@Named
public class NewsControl implements Serializable {
	private static final long serialVersionUID = 7039981650663567402L;

	@EJB
	private NewsManagerEJB gestion;
	
	private News news = new News();
	
	public News post() {
		return gestion.post(news);
	}

	public List<News> queryAll(){
		return gestion.queryAll();
	}
	
	public News queryById(int id) {
		news = gestion.queryById(id);
		return news;
	}

	public int queryIdFromEquals(News news) {
		return gestion.queryIdFromEquals(news);
	}
	
	public int queryIdFromEquals() {
		return gestion.queryIdFromEquals(news);
	}
	
	public boolean update() {
		return gestion.update(news);
	}
	
	public boolean delete() {
		return gestion.delete(news);
	}

	/*****************************
	   Getters & setters
	 *****************************/

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}
}
