package enael.eafc;

public enum Categorie {
	LUXE("Description de chambre luxueuse"), 
	GRAND_LUXE("Description de chambre grandement luxueuse"), 
	IMPERIAL("Description de chambre imperial");
	
	private String description;
	
	private Categorie(String description) {
		this.description=description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	

}
