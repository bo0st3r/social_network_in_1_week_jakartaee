package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.Member;
import be.helha.aemt.helper.Config;

@NamedQuery(name="Member.updateApproved", query="UPDATE Member m "
		+ "SET m.approved = :approved " 
		+ "WHERE m.idMember = :id")

@NamedQuery(name="Member.queryByPortrait", query="SELECT m FROM Member m WHERE m.portrait.idPortrait = :id")

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
	
	public boolean approveFormer(int id) {
		Query query = em.createNamedQuery("Member.updateApproved");
		query.setParameter("approved", true);
		query.setParameter("id", id);
		
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public Member queryByPortrait(int idPortrait) {
		Query query = em.createNamedQuery("Member.queryByPortrait");
		query.setParameter("id", idPortrait);
		List<Member> results = query.getResultList();
		if(results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
}
