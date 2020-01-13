package be.helha.aemt.entity;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.Major;

@Entity
public class OffreEmploi extends Offre {
	private String typeContrat;
	private Double salaire;
	
	public OffreEmploi() {
		super();
	}
	
	public OffreEmploi(String intituleOffre, String nomEntreprise, String descriptionOffre, Major section,
			Adresse adresse, String typeContrat, Double salaire) {
		super(intituleOffre, nomEntreprise, descriptionOffre, section, adresse);
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}

	public OffreEmploi(Integer idOffre, String intituleOffre, String nomEntreprise, String descriptionOffre,
			Major section, Adresse adresse, String typeContrat, Double salaire) {
		super(idOffre, intituleOffre, nomEntreprise, descriptionOffre, section, adresse);
		this.typeContrat = typeContrat;
		this.salaire = salaire;
	}

	public String getTypeContrat() {
		return typeContrat;
	}

	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((salaire == null) ? 0 : salaire.hashCode());
		result = prime * result + ((typeContrat == null) ? 0 : typeContrat.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OffreEmploi other = (OffreEmploi) obj;
		if (salaire == null) {
			if (other.salaire != null)
				return false;
		} else if (!salaire.equals(other.salaire))
			return false;
		if (typeContrat == null) {
			if (other.typeContrat != null)
				return false;
		} else if (!typeContrat.equals(other.typeContrat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.toString() + ", OffreEmploi [typeContrat=" + typeContrat + ", salaire=" + salaire + "]";
	}
	
	
}
