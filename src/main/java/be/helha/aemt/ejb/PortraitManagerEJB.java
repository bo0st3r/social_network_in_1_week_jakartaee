package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.PortraitDAO;
import be.helha.aemt.entity.Portrait;

@Stateless
public class PortraitManagerEJB {
	@EJB
	private PortraitDAO dao;
	
	public List<Portrait> queryAll(){
		return dao.queryAll();
	}
	
	public Portrait queryById(int id) {
		return dao.queryById(id);
	}
	
	public int queryIdFromEquals(Portrait portrait) {
		return dao.queryIdFromEquals(portrait);
	}
	
	public Portrait post(Portrait portrait) {
		return dao.post(portrait);
	}
	
	public boolean update(Portrait portrait) {
		return dao.update(portrait);
	}
	
	public boolean deleteById(int id) {
		return dao.deleteById(id);
	}
}
