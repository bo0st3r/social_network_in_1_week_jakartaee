package be.helha.aemt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import be.helha.aemt.enumeration.Major;

@Entity
public class Offre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOffre;
	
	private String intituleOffre;
	private String nomEntreprise;
	private String descriptionOffre;
	private Major section;
	private Adresse adresse;
	
	public Offre() {
		super();
	}
	
	public Offre(String intituleOffre, String nomEntreprise, String descriptionOffre, Major section,
			Adresse adresse) {
		super();
		this.intituleOffre = intituleOffre;
		this.nomEntreprise = nomEntreprise;
		this.descriptionOffre = descriptionOffre;
		this.section = section;
		this.adresse = adresse;
	}
	
	public Offre(Integer idOffre, String intituleOffre, String nomEntreprise, String descriptionOffre,
			Major section, Adresse adresse) {
		super();
		this.idOffre = idOffre;
		this.intituleOffre = intituleOffre;
		this.nomEntreprise = nomEntreprise;
		this.descriptionOffre = descriptionOffre;
		this.section = section;
		this.adresse = adresse;
	}

	public Integer getIdOffre() {
		return idOffre;
	}
	public void setIdOffre(Integer idOffre) {
		this.idOffre = idOffre;
	}
	public String getIntituleOffre() {
		return intituleOffre;
	}
	public void setIntituleOffre(String intituleOffre) {
		this.intituleOffre = intituleOffre;
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}
	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}
	public String getDescriptionOffre() {
		return descriptionOffre;
	}
	public void setDescriptionOffre(String descriptionOffre) {
		this.descriptionOffre = descriptionOffre;
	}
	public Major getSection() {
		return section;
	}
	public void setSection(Major section) {
		this.section = section;
	}
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((intituleOffre == null) ? 0 : intituleOffre.hashCode());
		result = prime * result + ((nomEntreprise == null) ? 0 : nomEntreprise.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		Offre other = (Offre) obj;
		if (intituleOffre == null) {
			if (other.intituleOffre != null)
				return false;
		} else if (!intituleOffre.equals(other.intituleOffre))
			return false;
		if (nomEntreprise == null) {
			if (other.nomEntreprise != null)
				return false;
		} else if (!nomEntreprise.equals(other.nomEntreprise))
			return false;
		if (section != other.section)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffre + ", intituleOffre=" + intituleOffre + ", nomEntreprise=" + nomEntreprise
				+ ", descriptionOffre=" + descriptionOffre + ", section=" + section + "]";
	}
	
	
	
	
}
