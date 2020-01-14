package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.NewsDAO;

@Stateless
public class NewsManagerEJB {
	@EJB
	private NewsDAO dao;
}
