package be.helha.aemt.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String city;
	private String street;
	private String number;
	private int postCode;	

	public Address() {
		super();
	}
	
	public Address(String city, String street, String number, int postCode) {
		super();
		this.city = city;
		this.street = street;
		this.number = number;
		this.postCode = postCode;
	}

	public Address(Integer id, String city, String street, String number, int postCode) {
		super();
		this.id = id;
		this.city = city;
		this.street = street;
		this.number = number;
		this.postCode = postCode;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postCode;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
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
		Address other = (Address) obj;
		if (postCode != other.postCode)
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", ville=" + city + ", rue=" + street + ", numero=" + number + ", codePostal="
				+ postCode + "]";
	}
	
	
	
}
