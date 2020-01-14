package be.helha.aemt.entity;

import java.time.LocalDate;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.GroupName;

@Entity
public class Admin extends Member {
	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String username, String password, LocalDate birthDate, byte[] photo) {
		super(firstName, lastName, username, password, birthDate, GroupName.ADMIN, photo);
	}

	public Admin(String firstName, String lastName, String username, String password, LocalDate birthDate) {
		super(firstName, lastName, username, password, birthDate, GroupName.ADMIN);
	}
}
