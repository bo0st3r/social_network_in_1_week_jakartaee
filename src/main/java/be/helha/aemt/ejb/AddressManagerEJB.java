package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AddressDAO;
import be.helha.aemt.entity.Address;

@Stateless
public class AddressManagerEJB {
	@EJB
	private AddressDAO dao;
	
	public List<Address> queryAll(){
		return dao.queryAll();
	}
	
	public Address queryById(int id) {
		return dao.queryById(id);
	}
	
	public Address queryEquals(Address address) {
		return dao.queryEquals(address);
	}
	
	public int queryIdFromEquals(Address address) {
		return dao.queryIdFromEquals(address);
	}
	
	public Address post(Address address) {
		return dao.post(address);
	}
}
