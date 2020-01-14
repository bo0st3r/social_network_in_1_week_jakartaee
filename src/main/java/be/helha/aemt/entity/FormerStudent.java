package be.helha.aemt.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import be.helha.aemt.enumeration.GroupName;
import be.helha.aemt.enumeration.Major;

@Entity
public class FormerStudent extends Member {
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
	}
	
	public FormerStudent(String firstName, String lastName, String username, String password, LocalDate birthDate,
			int graduationYear, Major major, String phoneNumber, boolean approved, Address address) {
		super(firstName, lastName, username, password, birthDate, new ArrayList<Offer>(), new ArrayList<Event>(), GroupName.FORMER, new byte[0]);
		this.graduationYear = graduationYear;
		this.phoneNumber = phoneNumber;
		this.approved = approved;
		this.major = major;
		this.address = address;
	}
	
	public FormerStudent(String firstName, String lastName, String username, String password, LocalDate birthDate,
			List<Offer> offers, List<Event> events, GroupName groupName, byte[] photo, int graduationYear,
			String phoneNumber, boolean approved, Major major, Portrait portrait, Address address) {
		super(firstName, lastName, username, password, birthDate, offers, events, groupName, photo);
		this.graduationYear = graduationYear;
		this.phoneNumber = phoneNumber;
		this.approved = approved;
		this.major = major;
		this.portrait = portrait;
		this.address = address;
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

	public int getGraduationYear() {
		System.out.println("GEET graduation");
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		System.out.println("SEET graduation");
		this.graduationYear = graduationYear;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "FormerStudent [graduationYear=" + graduationYear + ", phoneNumber=" + phoneNumber + ", approved="
				+ approved + ", major=" + major + ", portrait=" + portrait + ", address=" + address + ", getIdMembre()="
				+ getIdMembre() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getGroupName()="
				+ getGroupName() + ", getBirthDate()=" + getBirthDate() + "]";
	}
}
