package be.helha.aemt.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name="Event.queryAll", query="SELECT e FROM Event e ORDER BY e.dateEvent ASC"),
@NamedQuery(name="Event.queryById", query="SELECT e FROM Event e WHERE e.idEvent = :id"),
@NamedQuery(name="Event.queryEquals", query="SELECT e FROM Event e WHERE e.labelEvent = :label AND e.dateEvent = :date"),
@NamedQuery(name="Event.queryIdFromEquals", query="SELECT e.idEvent FROM Event e WHERE e.labelEvent = :label AND e.dateEvent = :date")
})

public class Event implements Serializable{
	private static final long serialVersionUID = -6258765974100413716L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEvent;

	private String labelEvent;
	private LocalDate dateEvent;
	private String descriptionEvent;
	private boolean approved;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] imageEvent;

	@ManyToOne(cascade = CascadeType.ALL)
	private Address addressEvent;

	public Event() {
		super();
	}

	public Event(String labelEvent, LocalDate dateEvent, String descriptionEvent, byte[] imageEvent,
			Address addressEvent) {
		super();
		this.labelEvent = labelEvent;
		this.dateEvent = dateEvent;
		this.descriptionEvent = descriptionEvent;
		this.approved = false;
		this.imageEvent = imageEvent;
		this.addressEvent = addressEvent;
	}

	public Event(Integer idEvent, String intituleEvent, LocalDate dateEvent, String descriptionEvent,
			byte[] imageEvent, Address addressEvent) {
		super();
		this.idEvent = idEvent;
		this.labelEvent = intituleEvent;
		this.dateEvent = dateEvent;
		this.descriptionEvent = descriptionEvent;
		this.approved = false;
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

	public LocalDate getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(LocalDate dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getDescriptionEvent() {
		return descriptionEvent;
	}

	public void setDescriptionEvent(String descriptionEvent) {
		this.descriptionEvent = descriptionEvent;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public byte[] getImageEvent() {
		return imageEvent;
	}

	public void setImageEvent(byte[] imageEvent) {
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
		return "Event [idEvent=" + idEvent + ", labelEvent=" + labelEvent + ", dateEvent=" + dateEvent
				+ ", descriptionEvent=" + descriptionEvent + ", approved=" + approved + ", addressEvent=" + addressEvent
				+ "]";
	}

	

	

}
