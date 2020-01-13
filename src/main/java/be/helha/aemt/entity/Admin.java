package be.helha.aemt.entity;

import java.sql.Date;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.GroupName;

@Entity
public class Admin extends Member {
	public Admin() {
		super();
	}

	public Admin(String firstName, String lastName, String username, String password, Date birthDate, byte[] photo) {
		super(firstName, lastName, username, password, GroupName.ADMIN, birthDate, photo);
	}

	public Admin(String firstName, String lastName, String username, String password, Date birthDate) {
		super(firstName, lastName, username, password, GroupName.ADMIN, birthDate);
	}
}
