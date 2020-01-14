package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.PortraitDAO;

@Stateless
public class PortraitManagerEJB {
	@EJB
	private PortraitDAO dao;
}
