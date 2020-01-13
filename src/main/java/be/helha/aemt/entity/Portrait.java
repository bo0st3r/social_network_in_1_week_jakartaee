package be.helha.aemt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Portrait implements Serializable {
	private static final long serialVersionUID = 5400446706308443675L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPortrait;
	private String intitule;
	private String contenu;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] picture;
	
	public Portrait() {
		
	}
	
	public Portrait(String intitule, String contenu) {
		this(intitule, contenu, new byte[0]);
	}
	
	public Portrait(String intitule, String contenu, byte[] picture) {
		super();
		this.intitule = intitule;
		this.contenu = contenu;
		this.picture = picture;
	}
	
	

	
	public Integer getIdPortrait() {
		return idPortrait;
	}
	
	public void setIdPortrait(Integer idPortrait) {
		this.idPortrait = idPortrait;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenu == null) ? 0 : contenu.hashCode());
		result = prime * result + ((intitule == null) ? 0 : intitule.hashCode());
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
		Portrait other = (Portrait) obj;
		if (contenu == null) {
			if (other.contenu != null)
				return false;
		} else if (!contenu.equals(other.contenu))
			return false;
		if (intitule == null) {
			if (other.intitule != null)
				return false;
		} else if (!intitule.equals(other.intitule))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Portrait [id=" + idPortrait + ", intitule=" + intitule + ", contenu=" + contenu + "]";
	}

}
