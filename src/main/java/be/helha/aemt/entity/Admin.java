package be.helha.aemt.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.GroupName;

@Entity
public class Admin extends Member {

	public Admin() {
	}

	public Admin(String firstName, String lastName, String username, String password, LocalDate birthDate,
			List<Offer> offers, List<Event> events, GroupName groupName, byte[] photo) {
		super(firstName, lastName, username, password, birthDate, offers, events, groupName, photo);
	}
	
	public Admin(String firstName, String lastName, String username, String password, LocalDate birthDate) {
		super(firstName, lastName, username, password, birthDate, new ArrayList<Offer>(),
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
