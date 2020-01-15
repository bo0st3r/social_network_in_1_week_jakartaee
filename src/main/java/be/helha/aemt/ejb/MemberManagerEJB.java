package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;

import be.helha.aemt.dao.MemberDAO;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;

@Stateless
public class MemberManagerEJB {
	@EJB
	private MemberDAO dao;

	public List<Member> selectAll() {
		
		 return dao.selectAll();
	}

	public Member add(Member m) {
		return dao.add(m);
	}

	public Member findByUsername(String username) {
		return dao.findByUsername(username);
	}
	
	public int findIdByUsername(String username) {
		return dao.findIdByUsername(username);
	}
	
	public boolean updateFormerApproved(String username, boolean approved) {
		return dao.updateFormerApproved(username, approved);
	}
	
	public FormerStudent queryByPortrait(int idPortrait) {
		return (FormerStudent) dao.queryByPortrait(idPortrait);
	}

}
