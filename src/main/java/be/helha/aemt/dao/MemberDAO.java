package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;
import be.helha.aemt.helper.Config;

@Stateless
@LocalBean
public class MemberDAO {
	@PersistenceContext(unitName = Config.UNIT_NAME)
	private EntityManager em;
	
	public List<Member> selectAll() {
		String sqlString = "SELECT m FROM Member m";
		Query selectAll = em.createQuery(sqlString);
//		System.out.println("DAO IN");
//		List<Member> m = selectAll.getResultList();
//		System.out.println(m);
//		System.out.println("DAO OUT");
		return selectAll.getResultList();
	}

	public Member add(Member m) {
//			if (find(u) == null) {
		em.persist(m);
//			}

		return null;
	}
	
	public Member findByUsername(String username) {
		String sqlString = "SELECT m FROM Member m WHERE m.username = :username";

		Query selectU = em.createQuery(sqlString);
		selectU.setParameter("username", username);
		List<Member> tmp = selectU.getResultList();

		return tmp.size() == 0 ? null : tmp.get(0);
	}
	
	public boolean approveFormer(FormerStudent former) {
		Member member = findByUsername(former.getUsername());
		if(member != null) {
			FormerStudent approved = (FormerStudent) member;
			approved.setApproved(!approved.isApproved());
			approved = em.merge(approved);
			
			return ((FormerStudent)findByUsername(former.getUsername())).isApproved();
		}
		
		return false;
	}
	
	public FormerStudent queryByPortrait(int idPortrait) {
		Query query = em.createNamedQuery("Member.queryByPortrait");
		query.setParameter("id", idPortrait);
		List<FormerStudent> results = query.getResultList();
		if(results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
}
