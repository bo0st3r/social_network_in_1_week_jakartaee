package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EventDAO;

@Stateless
public class EventManagerEJB {
	@EJB
	private EventDAO dao;
}
