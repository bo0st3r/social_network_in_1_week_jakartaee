package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.MemberManagerEJB;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;
import be.helha.aemt.util.UserPattern;

@SessionScoped
@Named
public class MemberControl implements Serializable {
	private static final long serialVersionUID = -37955545070490897L;
	@EJB
	private MemberManagerEJB gestion;
	private Member member = new Member();

	public Member addMember() {
		return gestion.add(member);
	}

	public List<Member> selectMembers() {
		return gestion.selectAll();
	}
	
	public List<FormerStudent> selectFormerStudents() {
		return gestion.selectAllFormers();
	}
	
	public List<FormerStudent> selectUnapprovedFormerStudents() {
		System.out.println(gestion.selectAllUnaprovedFormers());
		return gestion.selectAllUnaprovedFormers();
	}
	
	public void updateFormerApproved(FormerStudent fs, Boolean approve) {
		if(approve) {
			gestion.updateFormerApproved(fs.getMail(), true);
		} else {
			gestion.deleteMember(fs);
		}
	}

	
	public int findIdByUsername(String username) {
		return gestion.findIdByUsername(username);
	}
	
	public int findIdByMail(String mail) {
		return gestion.findIdByMail(mail);
	}
	
	public long queryFormerAmountToApprove() {
		return gestion.queryFormerAmountToApprove();
	}

	/*****************************
	 * Pages path getters
	 *****************************/
	public String doIndex() {
		return "index.xhtml";
	}

	public String doList() {
		return "list.xhtml";
	}
	
	public String selectMailPattern() {
		return UserPattern.MAIL_PATTERN.pattern();
	}
	
	public String selectUsernamePattern() {
		return UserPattern.USERNAME_PATTERN.pattern();
	}
	
	public String selectPasswordPattern() {
		return UserPattern.PASSWORD_PATTERN.pattern();
	}
	
	public String selectNamePattern() {
		return UserPattern.NAME_PATTERN.pattern();
	}

	/*****************************
	 * Getters & setters
	 *****************************/
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
