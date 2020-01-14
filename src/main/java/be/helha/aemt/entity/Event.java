package be.helha.aemt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvent;

	private String labelEvent;
	private Date dateEvent;
	private String descriptionEvent;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private Byte[] imageEvent;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address addressEvent;

	public Event() {
		super();
	}

	public Event(String labelEvent, Date dateEvent, String descriptionEvent, Byte[] imageEvent,
			Address addressEvent) {
		super();
		this.labelEvent = labelEvent;
		this.dateEvent = dateEvent;
		this.descriptionEvent = descriptionEvent;
		this.imageEvent = imageEvent;
		this.addressEvent = addressEvent;
	}

	public Event(Integer idEvent, String intituleEvent, Date dateEvent, String descriptionEvent,
			Byte[] imageEvent, Address addressEvent) {
		super();
		this.idEvent = idEvent;
		this.labelEvent = intituleEvent;
		this.dateEvent = dateEvent;
		this.descriptionEvent = descriptionEvent;
		this.imageEvent = imageEvent;
		this.addressEvent = addressEvent;
	}

	public Integer getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Integer idEvent) {
		this.idEvent = idEvent;
	}

	public String getLabelEvent() {
		return labelEvent;
	}

	public void setLabelEvent(String labelEvent) {
		this.labelEvent = labelEvent;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getDescriptionEvent() {
		return descriptionEvent;
	}

	public void setDescriptionEvent(String descriptionEvent) {
		this.descriptionEvent = descriptionEvent;
	}

	public Byte[] getImageEvent() {
		return imageEvent;
	}

	public void setImageEvent(Byte[] imageEvent) {
		this.imageEvent = imageEvent;
	}

	public Address getAddressEvent() {
		return addressEvent;
	}

	public void setAddressEvent(Address addressEvent) {
		this.addressEvent = addressEvent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateEvent == null) ? 0 : dateEvent.hashCode());
		result = prime * result + ((labelEvent == null) ? 0 : labelEvent.hashCode());
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
		Event other = (Event) obj;
		if (dateEvent == null) {
			if (other.dateEvent != null)
				return false;
		} else if (!dateEvent.equals(other.dateEvent))
			return false;
		if (labelEvent == null) {
			if (other.labelEvent != null)
				return false;
		} else if (!labelEvent.equals(other.labelEvent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evenement [idEvenement=" + idEvent + ", intituleEvenement=" + labelEvent + ", dateEvenement="
				+ dateEvent + "]";
	}

}
