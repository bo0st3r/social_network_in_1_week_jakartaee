package be.helha.aemt.enumeration;

public enum GroupName {
	FORMER("Ancien"), ADMIN("Admin");
	
	private String name;
	private GroupName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
