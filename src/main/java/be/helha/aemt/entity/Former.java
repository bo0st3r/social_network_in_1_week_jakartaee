package be.helha.aemt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;


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
		
	}
	
	public Former(int graduationYear, String phoneNumber, boolean approved, Portrait portrait) {
		this(graduationYear, null, phoneNumber, approved, portrait);
	}
	
	public Former(int graduationYear, Major major, String phoneNumber, boolean approved, Portrait portrait) {
		super();
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
	
}
