package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.MemberDAO;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;
import be.helha.aemt.util.SHA256Hasher;

@Stateless
public class MemberManagerEJB {
	@EJB
	private MemberDAO dao;

	public List<Member> selectAll() {
		return dao.selectAll();
	}
	
	public List<FormerStudent> selectAllFormers() {
		return dao.selectAllFormers();
	}

	public Member add(Member m) {
		return dao.add(m);
	}

	public Member hashAndAdd(Member m) {
		String hashedPassword = SHA256Hasher.hash(m.getPassword());
		m.setPassword(hashedPassword);
		return add(m);
	}

	public Member findByUsername(String username) {
		return dao.findByUsername(username);
	}

	public int findIdByUsername(String username) {
		int id = dao.findIdByUsername(username);
		return (id > 0) ? id : -1;
	}

	public Member findByMail(String mail) {
		return dao.findByMail(mail);
	}

	public int findIdByMail(String mail) {
		int id = dao.findIdByMail(mail);
		return (id > 0) ? id : -1;
	}

	public boolean updateFormerApproved(String username, boolean approved) {
		return dao.updateFormerApproved(username, approved);
	}

	public FormerStudent queryByPortrait(int idPortrait) {
		return (FormerStudent) dao.queryByPortrait(idPortrait);
	}
	
	public long queryFormerAmountToApprove() {
		return dao.queryFormerAmountToApprove();
	}
	public Member queryById(int id) {
		return dao.queryById(id);
	}

}
