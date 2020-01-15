package be.helha.aemt.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Portrait.queryAll", query="SELECT p FROM Portrait p"),
	@NamedQuery(name="Portrait.queryById", query="SELECT p FROM Portrait p WHERE p.idPortrait = :id"),
	@NamedQuery(name="Portrait.queryIdFromEquals", query="SELECT p .idPortrait FROM Portrait p WHERE p.label = :label")

})
public class Portrait implements Serializable {
	private static final long serialVersionUID = 5400446706308443675L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPortrait;
	private String label;
	private String content;
	
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] picture;
	
	public Portrait() {
		
	}
	
	public Portrait(String intitule, String contenu) {
		this(intitule, contenu, new byte[0]);
	}
	
	public Portrait(String intitule, String contenu, byte[] picture) {
		super();
		this.label = intitule;
		this.content = contenu;
		this.picture = picture;
	}
	
	

	
	public Integer getIdPortrait() {
		return idPortrait;
	}
	
	public void setIdPortrait(Integer idPortrait) {
		this.idPortrait = idPortrait;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String intitule) {
		this.label = intitule;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String contenu) {
		this.content = contenu;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Portrait other = (Portrait) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Portrait [id=" + idPortrait + ", intitule=" + label + ", contenu=" + content + "]";
	}

}
