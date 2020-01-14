package be.helha.aemt.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNews;
	private String name;
	private String description;
	private Date postingDate;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] picture;

	public News() {
		super();
	}

	public News(String name, String description, Date postingDate) {
		this(name, description, postingDate, new byte[0]);
	}

	public News(String name, String description, Date postingDate, byte[] picture) {
		super();
		this.name = name;
		this.description = description;
		this.postingDate = postingDate;
		this.picture = picture;
	}

	public Integer getIdNews() {
		return idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		News other = (News) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
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
		return "News [idNews=" + idNews + ", name=" + name + ", description=" + description + ", postingDate="
				+ postingDate + "]";
	}
}
