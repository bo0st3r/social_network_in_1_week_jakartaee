package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.OfferDAO;

@Stateless
public class OfferManagerEJB {
	@EJB
	private OfferDAO dao;
}
