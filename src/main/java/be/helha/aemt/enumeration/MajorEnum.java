package be.helha.aemt.enumeration;

public enum MajorEnum {
	AssistantDirection("Bachelier Assistant de direction"),
	Comptabilite("Bachelier en Comptabilité"),
	InformatiqueGestion("Bachelier en Informatique de gestion");
	
	private String nom;
	
	private MajorEnum(String nom) {
		this.nom = nom;
	}
}
