package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import be.helha.aemt.entity.Member;
import be.helha.aemt.helper.Config;

@Stateless
@LocalBean
public class MemberDAO {
	@PersistenceContext(unitName = Config.UNIT_NAME)
	private EntityManager em;
	
	public List<Member> selectAll() {
		Query selectAll = em.createNamedQuery("Member.queryAll");
		return selectAll.getResultList();
	}

	public Member add(Member m) {
//			if (find(u) == null) {
		em.persist(m);
//			}

		return null;
	}
	
	public Member findByUsername(String username) {
		Query selectU = em.createNamedQuery("Member.queryByUsername");
		selectU.setParameter("username", username);
		List<Member> tmp = selectU.getResultList();

		return tmp.size() == 0 ? null : tmp.get(0);
	}
	
	public boolean approveFormer(int id) {
		Query query = em.createNamedQuery("FormerStudent.updateApproved");
		query.setParameter("approved", true);
		query.setParameter("id", id);
		
		if(query.executeUpdate() > 0) {
			return true;
		}
		return false;
	}
	
	public Member queryByPortrait(int idPortrait) {
		Query query = em.createNamedQuery("FormerStudent.queryByPortrait");
		query.setParameter("id", idPortrait);
		List<Member> results = query.getResultList();
		if(results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
}
