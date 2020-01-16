package be.helha.aemt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
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
import javax.persistence.IdClass;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import be.helha.aemt.enumeration.GroupName;

@Entity
@IdClass(MemberKey.class)
@Inheritance(
	    strategy = InheritanceType.SINGLE_TABLE
)
@NamedQueries({
	@NamedQuery(name="Member.queryAll", query="SELECT m FROM Member m"),
	@NamedQuery(name="Member.queryByUsername", query="SELECT m FROM Member m WHERE m.username = :username"),
	@NamedQuery(name="Member.queryByMail", query="SELECT m FROM Member m WHERE m.mail = :mail"),
	@NamedQuery(name="Member.queryIdByUsername", query="SELECT m.idMember FROM Member m WHERE m.username = :username"),
	@NamedQuery(name="Member.queryIdByMail", query="SELECT m.idMember FROM Member m WHERE m.mail = :mail"),
})
public class Member implements Serializable{
	private static final long serialVersionUID = 3414596716371149696L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMember;
	@Id
	private String mail;
	
	private String username;
	private String firstName;
	private String lastName;
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
	
	public Member(String firstName, String lastName, String username, String password, String mail, LocalDate birthDate,
			List<Offer> offers, List<Event> events, GroupName groupName, byte[] photo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.birthDate = birthDate;
		this.offers = offers;
		this.events = events;
		this.groupName = groupName;
		this.photo = photo;
	}

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

	public Integer getIdMember() {
		return idMember;
	}

	public void setIdMember(Integer idMembre) {
		this.idMember = idMembre;
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


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public List<Offer> getOffers() {
		return offers;
	}


	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}


	public List<Event> getEvents() {
		return events;
	}


	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public String toString() {
		return "Member [idMember=" + idMember + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", mail=" + mail + ", birthDate=" + birthDate + ", offers="
				+ offers + ", events=" + events + ", groupName=" + groupName + ", photo=" + Arrays.toString(photo)
				+ "]";
	}
}
