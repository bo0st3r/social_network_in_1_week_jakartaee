package be.helha.aemt.enumeration;

public enum Major {
	AssistantDirection("Bachelier Assistant de direction"),
	Comptabilite("Bachelier en Comptabilité"),
	InformatiqueGestion("Bachelier en Informatique de gestion");
	
	private String name;
	private Major(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
