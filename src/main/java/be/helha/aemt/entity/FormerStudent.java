package be.helha.aemt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import be.helha.aemt.enumeration.GroupName;
import be.helha.aemt.enumeration.Major;

@Entity
public class FormerStudent extends Member implements Serializable {
	private static final long serialVersionUID = 6986371452166977771L;
	private int graduationYear;
	private String phoneNumber;
	private boolean approved;

	@Enumerated(EnumType.STRING)
	private Major major;

	@OneToOne(cascade = CascadeType.ALL, optional = true)
	private Portrait portrait;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;

	public FormerStudent() {
		super();
	}

	public FormerStudent(String firstName, String lastName, String username, String password, LocalDate birthDate,
			int graduationYear, Major major, String phoneNumber, boolean approved) {
		this(firstName, lastName, username, password, birthDate, graduationYear, major, phoneNumber, approved, null);
	}

	public FormerStudent(String firstName, String lastName, String username, String password, LocalDate birthDate,
			int graduationYear, Major major, String phoneNumber, boolean approved, Portrait portrait) {
		super(firstName, lastName, username, password, birthDate, GroupName.FORMER);
		this.graduationYear = graduationYear;
		this.major = major;
		this.phoneNumber = phoneNumber;
		this.approved = approved;
		this.portrait = portrait;
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Portrait getPortrait() {
		return portrait;
	}

	public void setPortrait(Portrait portrait) {
		this.portrait = portrait;
	}

	@Override
	public String toString() {
		return "Former [graduationYear=" + graduationYear + ", major=" + major + ", phoneNumber=" + phoneNumber
				+ ", approved=" + approved + ", portrait=" + portrait + "]";
	}

}
