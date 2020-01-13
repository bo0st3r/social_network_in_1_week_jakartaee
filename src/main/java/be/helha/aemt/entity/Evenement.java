package be.helha.aemt.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Evenement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvenement;
	
	private String intituleEvenement;
	private Date dateEvenement;
	private String descriptionEvenement;
	private Byte[] imageEvenement;
	private Adresse adresseEvenement;

	public Evenement() {
		super();
	}

	public Evenement(String intituleEvenement, Date dateEvenement, String descriptionEvenement, Byte[] imageEvenement,
			Adresse adresseEvenement) {
		super();
		this.intituleEvenement = intituleEvenement;
		this.dateEvenement = dateEvenement;
		this.descriptionEvenement = descriptionEvenement;
		this.imageEvenement = imageEvenement;
		this.adresseEvenement = adresseEvenement;
	}

	public Evenement(Integer idEvenement, String intituleEvenement, Date dateEvenement, String descriptionEvenement,
			Byte[] imageEvenement, Adresse adresseEvenement) {
		super();
		this.idEvenement = idEvenement;
		this.intituleEvenement = intituleEvenement;
		this.dateEvenement = dateEvenement;
		this.descriptionEvenement = descriptionEvenement;
		this.imageEvenement = imageEvenement;
		this.adresseEvenement = adresseEvenement;
	}

	public Integer getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Integer idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getIntituleEvenement() {
		return intituleEvenement;
	}

	public void setIntituleEvenement(String intituleEvenement) {
		this.intituleEvenement = intituleEvenement;
	}

	public Date getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	public String getDescriptionEvenement() {
		return descriptionEvenement;
	}

	public void setDescriptionEvenement(String descriptionEvenement) {
		this.descriptionEvenement = descriptionEvenement;
	}

	public Byte[] getImageEvenement() {
		return imageEvenement;
	}

	public void setImageEvenement(Byte[] imageEvenement) {
		this.imageEvenement = imageEvenement;
	}

	public Adresse getAdresseEvenement() {
		return adresseEvenement;
	}

	public void setAdresseEvenement(Adresse adresseEvenement) {
		this.adresseEvenement = adresseEvenement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEvenement == null) ? 0 : dateEvenement.hashCode());
		result = prime * result + ((intituleEvenement == null) ? 0 : intituleEvenement.hashCode());
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
		Evenement other = (Evenement) obj;
		if (dateEvenement == null) {
			if (other.dateEvenement != null)
				return false;
		} else if (!dateEvenement.equals(other.dateEvenement))
			return false;
		if (intituleEvenement == null) {
			if (other.intituleEvenement != null)
				return false;
		} else if (!intituleEvenement.equals(other.intituleEvenement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evenement [idEvenement=" + idEvenement + ", intituleEvenement=" + intituleEvenement + ", dateEvenement="
				+ dateEvenement + "]";
	}
	
	
	

}
