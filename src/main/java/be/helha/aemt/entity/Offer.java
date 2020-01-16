package be.helha.aemt.entity;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import be.helha.aemt.enumeration.Major;

@Entity
@NamedQueries({
	@NamedQuery(name="Offer.queryAll", query="SELECT o FROM Offer o ORDER BY o.postingDate ASC"), 
	@NamedQuery(name="Offer.queryById", query="SELECT o FROM Offer o WHERE o.idOffer = :id"),
	@NamedQuery(name="Offer.queryIdFromEquals", query="SELECT o.idOffer FROM Offer o WHERE o.labelOffer = :label AND o.companyName = :company AND o.postingDate = :date")

})
public class Offer implements Serializable{
	private static final long serialVersionUID = 5727714600467180931L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOffer;
	
	private String labelOffer;
	private String companyName;
	private String descriptionOffer;
	private Date startingDate;
	private Date postingDate;
	private boolean approved;
	private Major major;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Address address;
	
	public Offer() {
		super();
	}

	public Offer(String labelOffer, String companyName, String descriptionOffer, Date startingDate, Date postingDate,
			boolean approved, Major major) {
		super();
		this.labelOffer = labelOffer;
		this.companyName = companyName;
		this.descriptionOffer = descriptionOffer;
		this.startingDate = startingDate;
		this.postingDate = postingDate;
		this.approved = approved;
		this.major = major;
	}
	
	public Offer(String labelOffer, String companyName, String descriptionOffer, Date startingDate, Date postingDate,
			boolean approved, Major major, Address address) {
		super();
		this.labelOffer = labelOffer;
		this.companyName = companyName;
		this.descriptionOffer = descriptionOffer;
		this.startingDate = startingDate;
		this.postingDate = postingDate;
		this.approved = approved;
		this.major = major;
		this.address = address;
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

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((companyName == null) ? 0 : companyName.hashCode());
		result = prime * result + ((labelOffer == null) ? 0 : labelOffer.hashCode());
		result = prime * result + ((postingDate == null) ? 0 : postingDate.hashCode());
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
		if (companyName == null) {
			if (other.companyName != null)
				return false;
		} else if (!companyName.equals(other.companyName))
			return false;
		if (labelOffer == null) {
			if (other.labelOffer != null)
				return false;
		} else if (!labelOffer.equals(other.labelOffer))
			return false;
		if (postingDate == null) {
			if (other.postingDate != null)
				return false;
		} else if (!postingDate.equals(other.postingDate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Offer [idOffer=" + idOffer + ", labelOffer=" + labelOffer + ", companyName=" + companyName
				+ ", descriptionOffer=" + descriptionOffer + ", startingDate=" + startingDate + ", postingDate="
				+ postingDate + ", approved=" + approved + ", major=" + major + ", address=" + address + "]";
	}
	
	
	
}
