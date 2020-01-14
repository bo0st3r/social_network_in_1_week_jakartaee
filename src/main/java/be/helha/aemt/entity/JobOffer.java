package be.helha.aemt.entity;

import java.util.Date;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.MajorEnum;

@Entity
public class JobOffer extends Offer {
	private String contractType;
	private Double salary;
	
	public JobOffer() {
		super();
	}
	
	

	public JobOffer(String labelOffer, String companyName, String descriptionOffer, Date startingDate, Date postingDate,
			boolean approved, MajorEnum major, String contractType, Double salary) {
		super(labelOffer, companyName, descriptionOffer, startingDate, postingDate, approved, major);
		this.contractType = contractType;
		this.salary = salary;
	}



	public JobOffer(String labelOffer, String companyName, String descriptionOffer, Date startingDate, Date postingDate,
			boolean approved, MajorEnum major, Address address, String contractType, Double salary) {
		super(labelOffer, companyName, descriptionOffer, startingDate, postingDate, approved, major, address);
		this.contractType = contractType;
		this.salary = salary;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
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
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (contractType == null) {
			if (other.contractType != null)
				return false;
		} else if (!contractType.equals(other.contractType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.toString() + ", OffreEmploi [typeContrat=" + contractType + ", salaire=" + salary + "]";
	}
	
	
}
