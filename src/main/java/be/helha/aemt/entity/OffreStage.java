package be.helha.aemt.entity;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.Major;

@Entity
public class OffreStage extends Offre {
	private String periode;
	private String duree;
	private boolean possibiliteTFE;

	public OffreStage() {
		super();
	}

	public OffreStage(String intituleOffre, String nomEntreprise, String descriptionOffre, Major section,
			Adresse adresse, String periode, String duree, boolean possibiliteTFE) {
		super(intituleOffre, nomEntreprise, descriptionOffre, section, adresse);
		this.periode = periode;
		this.duree = duree;
		this.possibiliteTFE = possibiliteTFE;
	}

	public OffreStage(Integer idOffre, String intituleOffre, String nomEntreprise, String descriptionOffre,
			Major section, Adresse adresse, String periode, String duree, boolean possibiliteTFE) {
		super(idOffre, intituleOffre, nomEntreprise, descriptionOffre, section, adresse);
		this.periode = periode;
		this.duree = duree;
		this.possibiliteTFE = possibiliteTFE;
	}

	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public boolean isPossibiliteTFE() {
		return possibiliteTFE;
	}

	public void setPossibiliteTFE(boolean possibiliteTFE) {
		this.possibiliteTFE = possibiliteTFE;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((duree == null) ? 0 : duree.hashCode());
		result = prime * result + ((periode == null) ? 0 : periode.hashCode());
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
		OffreStage other = (OffreStage) obj;
		if (duree == null) {
			if (other.duree != null)
				return false;
		} else if (!duree.equals(other.duree))
			return false;
		if (periode == null) {
			if (other.periode != null)
				return false;
		} else if (!periode.equals(other.periode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", OffreStage [periode=" + periode + ", duree=" + duree + ", possibiliteTFE=" + possibiliteTFE
				+ "]";
	}
	
	
}
