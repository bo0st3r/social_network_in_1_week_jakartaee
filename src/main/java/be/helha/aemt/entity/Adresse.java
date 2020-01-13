package be.helha.aemt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String ville;
	private String rue;
	private String numero;
	private int codePostal;	

	public Adresse() {
		super();
	}
	
	public Adresse(String ville, String rue, String numero, int codePostal) {
		super();
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
	}

	public Adresse(Integer id, String ville, String rue, String numero, int codePostal) {
		super();
		this.id = id;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.codePostal = codePostal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codePostal;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (codePostal != other.codePostal)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Adresse [id=" + id + ", ville=" + ville + ", rue=" + rue + ", numero=" + numero + ", codePostal="
				+ codePostal + "]";
	}
	
	
	
}
