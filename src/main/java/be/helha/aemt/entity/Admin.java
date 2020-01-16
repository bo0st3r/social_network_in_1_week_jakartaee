package be.helha.aemt.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.GroupName;

@Entity
public class Admin extends Member {
	private static final long serialVersionUID = -8971486473972790040L;

	public Admin() {
		setGroupName(GroupName.ADMIN);
	}

	public Admin(String firstName, String lastName, String username, String password, String mail, LocalDate birthDate,
			List<Offer> offers, List<Event> events, byte[] photo) {
		super(firstName, lastName, username, password, mail, birthDate, offers, events, GroupName.ADMIN, photo);
	}
	
	public Admin(String firstName, String lastName, String username, String password, String mail, LocalDate birthDate) {
		super(firstName, lastName, username, password, mail, birthDate, new ArrayList<Offer>(),
				new ArrayList<Event>(), GroupName.ADMIN, new byte[0]);
	}
	
	

	
	

//	public Admin(String firstName, String lastName, String username, String password, LocalDate birthDate, byte[] photo) {
//		super(firstName, lastName, username, password, birthDate, GroupName.ADMIN, photo);
//	}
//
//	public Admin(String firstName, String lastName, String username, String password, LocalDate birthDate) {
//		super(firstName, lastName, username, password, birthDate, GroupName.ADMIN);
//	}
}
