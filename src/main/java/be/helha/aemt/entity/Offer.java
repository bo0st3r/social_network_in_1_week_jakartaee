package be.helha.aemt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import be.helha.aemt.enumeration.MajorEnum;

@Entity
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOffer;
	
	private String labelOffer;
	private String companyName;
	private String descriptionOffer;
	private MajorEnum major;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Address adress;
	
	public Offer() {
		super();
	}
	
	public Offer(String labelOffer, String companyName, String descriptionOffer, MajorEnum major,
			Address adress) {
		super();
		this.labelOffer = labelOffer;
		this.companyName = companyName;
		this.descriptionOffer = descriptionOffer;
		this.major = major;
		this.adress = adress;
	}
	
	public Offer(Integer idOffer, String labelOffer, String companyName, String descriptionOffer,
			MajorEnum major, Address adress) {
		super();
		this.idOffer = idOffer;
		this.labelOffer = labelOffer;
		this.companyName = companyName;
		this.descriptionOffer = descriptionOffer;
		this.major = major;
		this.adress = adress;
	}

	public Integer getIdOffer() {
		return idOffer;
	}

	public void setIdOffer(Integer idOffer) {
		this.idOffer = idOffer;
	}

	public String getLabelOffer() {
		return labelOffer;
	}

	public void setLabelOffer(String labelOffer) {
		this.labelOffer = labelOffer;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDescriptionOffer() {
		return descriptionOffer;
	}

	public void setDescriptionOffer(String descriptionOffer) {
		this.descriptionOffer = descriptionOffer;
	}

	public MajorEnum getMajor() {
		return major;
	}

	public void setMajor(MajorEnum major) {
		this.major = major;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((labelOffer == null) ? 0 : labelOffer.hashCode());
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
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
		Offer other = (Offer) obj;
		if (labelOffer == null) {
			if (other.labelOffer != null)
				return false;
		} else if (!labelOffer.equals(other.labelOffer))
			return false;
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (major != other.major)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Offre [idOffre=" + idOffer + ", intituleOffre=" + labelOffer + ", nomEntreprise=" + companyName
				+ ", descriptionOffre=" + descriptionOffer + ", section=" + major + "]";
	}
	
	
	
	
}
