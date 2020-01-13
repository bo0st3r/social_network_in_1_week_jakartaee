package be.helha.aemt.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import be.helha.aemt.enumeration.GroupName;
import be.helha.aemt.enumeration.Major;


@Entity
public class Former extends Member implements Serializable {
	private static final long serialVersionUID = 6986371452166977771L;
	
	private int graduationYear;
	private Major major;
	private String phoneNumber;
	private boolean approved;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true)
	private Portrait portrait;

	public Former() {
		super();
	}
	
	public Former(String firstName, String lastName, String username, String password, 
			Date birthDate, int graduationYear, Major major, String phoneNumber, boolean approved) {
		this(firstName, lastName, username, password, birthDate, graduationYear, major, phoneNumber, approved, null);
	}
	
	public Former(String firstName, String lastName, String username, String password,
			Date birthDate, int graduationYear, Major major, String phoneNumber, boolean approved, Portrait portrait) {
		super(firstName, lastName, username, password, GroupName.FORMER, birthDate);
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
