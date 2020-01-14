package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.MemberDAO;
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
	
	public boolean approveFormer(int id) {
		return dao.approveFormer(id);
	}
	
	public Member queryByPortrait(int idPortrait) {
		return dao .queryByPortrait(idPortrait);
	}

}