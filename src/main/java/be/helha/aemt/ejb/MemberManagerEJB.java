package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.MemberDAO;
import be.helha.aemt.entity.Member;

@Stateless
public class MemberManagerEJB implements IMemberManagerEJB{
	@EJB
	private MemberDAO dao;

	@Override
	public List<Member> selectAll() {
		
		 return dao.selectAll();
	}

	@Override
	public Member add(Member m) {
		return dao.add(m);
	}

	@Override
	public Member findByUsername(String username) {
		return dao.findByUsername(username);
	}

}
