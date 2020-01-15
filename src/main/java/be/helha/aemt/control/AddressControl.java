package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.AddressManagerEJB;
import be.helha.aemt.entity.Address;


@SessionScoped
@Named
public class AddressControl implements Serializable {
	private static final long serialVersionUID = -7178054222165233926L;
	
	@EJB
	private AddressManagerEJB gestion;
	
	private Address address = new Address();
	
	public Address post() {
		return gestion.post(address);
	}
	
	public List<Address> queryAll(){
		
		return gestion.queryAll();
	}
	
	public Address queryById(int id) {
		address = gestion.queryById(id);
		return address;
	}

	public Address queryEquals(Address address) {
		this.address = gestion.queryEquals(address);
		return this.address;
	}

	public Address queryEquals() {
		this.address = gestion.queryEquals(address);
		return this.address;
	}
	
	public int queryIdFromEquals(Address address) {
		return gestion.queryIdFromEquals(address);
	}
	
	public int queryIdFromEquals() {
		return gestion.queryIdFromEquals(address);
	}
	

	/*****************************
	   Getters & setters
	 *****************************/
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
