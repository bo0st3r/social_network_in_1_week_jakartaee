package be.helha.aemt.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import be.helha.aemt.enumeration.MajorEnum;

@Entity
public class InternshipOffer extends Offer implements Serializable{
	private String period;
	private String duration;
	private boolean thesisPossibility;

	public InternshipOffer() {
		super();
	}

	public InternshipOffer(String labelOffer, String companyName, String descriptionOffer, MajorEnum major, Address adress,
			String period, String duration, boolean thesisPossibility) {
		super(labelOffer, companyName, descriptionOffer, major, adress);
		this.period = period;
		this.duration = duration;
		this.thesisPossibility = thesisPossibility;
	}

	public InternshipOffer(Integer idOffer, String labelOffer, String companyName, String descriptionOffer, MajorEnum major,
			Address adress, String period, String duration, boolean thesisPossibility) {
		super(idOffer, labelOffer, companyName, descriptionOffer, major, adress);
		this.period = period;
		this.duration = duration;
		this.thesisPossibility = thesisPossibility;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public boolean isThesisPossibility() {
		return thesisPossibility;
	}

	public void setThesisPossibility(boolean thesisPossibility) {
		this.thesisPossibility = thesisPossibility;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((period == null) ? 0 : period.hashCode());
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
		InternshipOffer other = (InternshipOffer) obj;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (period == null) {
			if (other.period != null)
				return false;
		} else if (!period.equals(other.period))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", OffreStage [periode=" + period + ", duree=" + duration + ", possibiliteTFE=" + thesisPossibility
				+ "]";
	}
	
	
}
