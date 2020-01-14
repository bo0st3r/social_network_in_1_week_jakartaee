package be.helha.aemt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import be.helha.aemt.enumeration.GroupName;

@Entity
@Inheritance(
	    strategy = InheritanceType.SINGLE_TABLE
	)
public class Member implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMembre;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private LocalDate birthDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Offer> offers;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Event> events;

	@Enumerated(EnumType.STRING)
	private GroupName groupName;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] photo;

	public Member() {
	}
	
	
	public Member(String firstName, String lastName, String username, String password, LocalDate birthDate,
			List<Offer> offers, List<Event> events, GroupName groupName, byte[] photo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.birthDate = birthDate;
		this.offers = offers;
		this.events = events;
		this.groupName = groupName;
		this.photo = photo;
	}


//
//	public Member(String firstName, String lastName, String username, String password, LocalDate birthDate,
//			GroupName groupName) {
//		this(firstName, lastName, username, password, birthDate, new ArrayList<Offer>(), new ArrayList<Event>(), groupName, new byte[0]);
//	}
//	
//	public Member(String firstName, String lastName, String username, String password, LocalDate birthDate,
//			GroupName groupName, byte[] photo) {
//		this(firstName, lastName, username, password, birthDate, new ArrayList<Offer>(), new ArrayList<Event>(), groupName, photo);
//	}
//
//	public Member(String firstName, String lastName, String username, String password, LocalDate birthDate,
//			List<Offer> offers, List<Event> events, GroupName groupName) {
//		this(firstName, lastName, username, password, birthDate, offers, events, groupName, new byte[0]);
//	}
//
//	public Member(String firstName, String lastName, String username, String password, LocalDate birthDate,
//			List<Offer> offers, List<Event> events, GroupName groupName, byte[] photo) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.username = username;
//		this.password = password;
//		this.birthDate = birthDate;
//		this.offers = offers;
//		this.events = events;
//		this.groupName = groupName;
//		this.photo = photo;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public Integer getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(Integer idMembre) {
		this.idMembre = idMembre;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GroupName getGroupName() {
		return groupName;
	}

	public void setGroupName(GroupName groupName) {
		this.groupName = groupName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Member [idMembre=" + idMembre + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", birthDate=" + birthDate + ", groupName=" + groupName + "]";
	}

	
}
