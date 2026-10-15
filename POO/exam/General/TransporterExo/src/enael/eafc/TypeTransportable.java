package enael.eafc;

public enum TypeTransportable {
	PALETTE("Palette",1),
	LMPV("Véhicule leger",6),
	LAV("vehicules légers blindés",16),
	MBT("véhicules lourds",28);
	
	private String TitreComplet;
	private int placePrise;
	
	//le poid des palette pouvant varié il est preferable de ne pas l'mettre dans l'enum
	private TypeTransportable(String TitreComplet, int placePrise) {
		this.TitreComplet = TitreComplet;
		this.placePrise = placePrise;
	}

	public String getTitreComplet() {
		return TitreComplet;
	}

	public int getPlacePrise() {
		return placePrise;
	}	
	
}
