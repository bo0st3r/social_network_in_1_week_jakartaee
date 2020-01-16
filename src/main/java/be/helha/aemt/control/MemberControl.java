package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.MemberManagerEJB;
import be.helha.aemt.entity.Admin;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;
import be.helha.aemt.enumeration.GroupName;
import be.helha.aemt.util.UserPattern;

@SessionScoped
@Named
public class MemberControl implements Serializable {
	private static final long serialVersionUID = -37955545070490897L;
	@EJB
	private MemberManagerEJB gestion;
	private Member member = new Member();
//	private FormerStudent formerStudent = new FormerStudent();
//	private Admin admin = new Admin();

	public Member addMember() {
		return gestion.add(member);
	}

	public List<Member> selectMembers() {
		return gestion.selectAll();
	}
	
	public List<FormerStudent> selectFormerStudents() {
		return gestion.selectAllFormers();
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
	
	public boolean hasAdminRights() {
		return member.getGroupName() == GroupName.ADMIN;
	}
//	public Member queryById(int id) {
//		member = gestion.queryById(id);
//		if (member instanceof FormerStudent) {
//			formerStudent = (FormerStudent) member;
//		}else if(member instanceof Admin) {
//			admin = (Admin) member;
//		}
//		return member;
//	}

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
//	public void FormerStudentDetails() {
//		FacesContext fc= FacesContext.getCurrentInstance();
//		Map m = fc.getExternalContext().getRequestParameterMap();
//		int memberID= Integer.parseInt((String) m.get("idClicked"));
//		queryById(memberID);
//	}

}
