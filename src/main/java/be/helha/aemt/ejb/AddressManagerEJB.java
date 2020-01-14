package be.helha.aemt.ejb;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AddressDAO;

@Stateless
public class AddressManagerEJB {
	@EJB
	private AddressDAO dao;
}
