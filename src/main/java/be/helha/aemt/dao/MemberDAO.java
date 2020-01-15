package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
		Query selectAll = em.createNamedQuery("Member.queryAll");
		return selectAll.getResultList();
	}

	public Member add(Member m) {
		String username = m.getUsername();
		if (findIdByUsername(username) < 0) {
			em.persist(m);
			int id = findIdByUsername(username);
			m.setIdMember(id);
			return m;
		}

		return null;
	}

	public int findIdByUsername(String username) {
		Query selectU = em.createNamedQuery("Member.queryIdByUsername");
		selectU.setParameter("username", username);
		int id = (int) selectU.getResultList().get(0);
		return id;
	}

	public Member findByUsername(String username) {
		Query selectU = em.createNamedQuery("Member.queryByUsername");
		selectU.setParameter("username", username);
		List<Member> tmp = selectU.getResultList();

		return tmp.size() == 0 ? null : tmp.get(0);
	}

	public boolean updateFormerApproved(String username, boolean approved) {
		Member m = findByUsername(username);
		if (m instanceof FormerStudent) {
			FormerStudent fs = (FormerStudent) m;
			if (fs.isApproved() == approved) {
				fs.setApproved(approved);
				FormerStudent fsMerged = em.merge(fs);
				return fs.isApproved() != fsMerged.isApproved();
			} else {
				throw new IllegalArgumentException(
						"FormerStudent is already " + ((approved) ? "approved" : "unapproved"));
			}

		}

		throw new IllegalArgumentException("Given username not related to a FormerStudent.");
	}

	public FormerStudent queryByPortrait(int idPortrait) {
		Query query = em.createNamedQuery("FormerStudent.queryByPortrait");
		query.setParameter("id", idPortrait);
		List<FormerStudent> results = query.getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		return null;
	}
}
