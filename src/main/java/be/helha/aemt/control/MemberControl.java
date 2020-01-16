package be.helha.aemt.control;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import be.helha.aemt.ejb.MemberManagerEJB;
import be.helha.aemt.entity.Admin;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;
import be.helha.aemt.enumeration.GroupName;
import be.helha.aemt.enumeration.Major;

@SessionScoped
@Named
public class MemberControl implements Serializable {
	private static final long serialVersionUID = -37955545070490897L;
	public static final List<SelectItem> SELECTABLE_MAJORS = selectMajors();

	@EJB
	private MemberManagerEJB gestion;
	private Member member = new Member();
	private FormerStudent former = new FormerStudent();

	private Date birthDateToConvert;
	private String pswConfirm;
	private String mailConfirm;

	public void test() {
		if (birthDateToConvert != null) {
			LocalDate date = birthDateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			former.setBirthDate(date);
		}
		System.out.println(former);
		System.out.println(pswConfirm + " " + mailConfirm);
	}

	public Member addMember() {
		return gestion.add(member);

	}

	public List<Member> selectMembers() {
		return gestion.selectAll();
	}
	
//	public List<> selectMembers() {
//		return gestion.selectAll();
//	}


	public int findIdByUsername(String username) {
		return gestion.findIdByUsername(username);
	}
	
	public long queryFormerAmountToApprove() {
		return gestion.queryFormerAmountToApprove();
	}
	
	public boolean hasAdminRights() {
		System.out.println("group name:" + (member.getGroupName() == GroupName.ADMIN));
		System.out.println(member.getGroupName());
		System.out.println(member);
		return member.getGroupName() == GroupName.ADMIN;
	}

	public boolean doPswsMatch() {
		return former.getPassword().equals(pswConfirm);
	}

	public boolean doMailsMatch() {
		return former.getMail().equals(mailConfirm);
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

	/*****************************
	 * Getters & setters
	 *****************************/
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public FormerStudent getFormer() {
		return former;
	}

	public void setFormer(FormerStudent former) {
		this.former = former;
	}

	public Date getBirthDateToConvert() {
		return birthDateToConvert;
	}

	public void setBirthDateToConvert(Date birthDateToConvert) {
		this.birthDateToConvert = birthDateToConvert;
	}

	private static List<SelectItem> selectMajors() {
		ArrayList<SelectItem> selectables = new ArrayList<SelectItem>();
		for (Major major : Major.values()) {
			selectables.add(new SelectItem(major, major.toString()));
		}

		return selectables;
	}

	public List<SelectItem> getSelectableMajors() {
		return SELECTABLE_MAJORS;
	}

	public String getPswConfirm() {
		return pswConfirm;
	}

	public void setPswConfirm(String pswConfirm) {
		this.pswConfirm = pswConfirm;
	}

	public String getMailConfirm() {
		return mailConfirm;
	}

	public void setMailConfirm(String mailConfirm) {
		this.mailConfirm = mailConfirm;
	}
}
