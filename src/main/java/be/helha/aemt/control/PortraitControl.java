package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.PortraitManagerEJB;
import be.helha.aemt.entity.Portrait;

@SessionScoped
@Named
public class PortraitControl implements Serializable {

	private static final long serialVersionUID = -1070654463773798864L;

	@EJB
	private PortraitManagerEJB gestion;
	
	private Portrait portrait = new Portrait();

	public Portrait post() {
		return gestion.post(portrait);
	}
	
	public List<Portrait> queryAll(){
		return gestion.queryAll();
	}
	
	public Portrait queryById(int id) {
		portrait = gestion.queryById(id);
		return portrait;
	}

	public int queryIdFromEquals(Portrait portrait) {
		return gestion.queryIdFromEquals(portrait);
	}

	public int queryIdFromEquals() {
		return gestion.queryIdFromEquals(portrait);
	}

	public boolean update(Portrait portrait) {
		return gestion.update(portrait);
	}
	
	public boolean update() {
		return gestion.update(portrait);
	}

	public boolean delete(Portrait portrait) {
		return gestion.delete(portrait);
	}

	public boolean delete() {
		return gestion.delete(portrait);
	}
	
	/*****************************
		   Getters & setters
	*****************************/
	
	public Portrait getPortrait() {
		return portrait;
	}

	public void setPortrait(Portrait portrait) {
		this.portrait = portrait;
	}
	
	
}
