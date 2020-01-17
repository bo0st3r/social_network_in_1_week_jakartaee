package be.helha.aemt.entity;

import java.util.Date;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import be.helha.aemt.enumeration.Major;

@Entity
@NamedQueries({
	@NamedQuery(name="Offer.queryJob", query="SELECT o FROM JobOffer o ORDER BY o.postingDate ASC"),
	@NamedQuery(name="Offer.queryJobAmountToApprove", query="SELECT count(o) FROM JobOffer o WHERE o.approved = false")
})
public class JobOffer extends Offer implements Serializable{
	private static final long serialVersionUID = 6980329707198003072L;
	
	private String contractType;
	private Double salary;
	
	public JobOffer() {
		super();
	}
	
	

	public JobOffer(String labelOffer, String companyName, String descriptionOffer, LocalDate startingDate, LocalDate postingDate,
			boolean approved, Major major, String contractType) {
		super(labelOffer, companyName, descriptionOffer, startingDate, postingDate, approved, major);
		this.contractType = contractType;
	}



	public JobOffer(String labelOffer, String companyName, String descriptionOffer, LocalDate startingDate, LocalDate postingDate,
			boolean approved, Major major, Address address, String contractType) {
		super(labelOffer, companyName, descriptionOffer, startingDate, postingDate, approved, major, address);
		this.contractType = contractType;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((contractType == null) ? 0 : contractType.hashCode());
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
		JobOffer other = (JobOffer) obj;
		if (contractType == null) {
			if (other.contractType != null)
				return false;
		} else if (!contractType.equals(other.contractType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", OffreEmploi [typeContrat=" + contractType +  "]";
	}
	
	
}
