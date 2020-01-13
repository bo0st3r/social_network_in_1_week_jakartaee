package be.helha.aemt.enumeration;

public enum SectionEnum {
	AssistantDirection("Bachelier Assistant de direction"),
	Comptabilite("Bachelier en Comptabilité"),
	InformatiqueGestion("Bachelier en Informatique de gestion");
	
	private String nom;
	
	private SectionEnum(String nom) {
		this.nom = nom;
	}
}
