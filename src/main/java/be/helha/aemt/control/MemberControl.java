package be.helha.aemt.control;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;


import be.helha.aemt.ejb.IMemberManagerEJB;
import be.helha.aemt.entity.FormerStudent;
import be.helha.aemt.entity.Member;

@SessionScoped
@Named
public class MemberControl implements Serializable {
	private static final long serialVersionUID = -37955545070490897L;

	@EJB
	private IMemberManagerEJB gestion;
	
	private Member member = new FormerStudent();
	
	private Member addMember() {
		return gestion.add(member);
	}
	
	public List<Member> getMembers() {
		return gestion.selectAll();
	}
	
	
	/*****************************
	 	  Pages path getters
	*****************************/
	public String doIndex() {
		return "index.xhtml";
	}

	public String doList() {
		return "list.xhtml";
	}

	
	/*****************************
		   Getters & setters
	*****************************/
	public Member getUser() {
		return member;
	}

	public void setUser(Member member) {
		this.member = member;
	}
}
