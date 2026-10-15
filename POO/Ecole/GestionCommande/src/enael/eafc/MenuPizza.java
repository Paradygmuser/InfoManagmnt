package enael.eafc;

public enum MenuPizza {
	//voici le menu de pizza, avec son nom, son prix et si tout les ingredient sont present ou pas.
	//chaque enume est public statique et final.
	
	MARGHERITA("Margherita", 12, true),
	QUATREFROMAGGI("4 Fromaggi", 14, true),
	VEGETARIANA("Vegetariana", 13, true),
	KEFTA("Kefta",14,false),
	MEXICANA("Mexicana", 15, false),
	MILANO("Milano", 16, false),
	BARBECUE("Barbecue", 14, false),
	FUNGI("Fungi", 12, true);
	
	private final String nom;
	private final double prix;
	private final boolean ingredient;
	
	MenuPizza(String nom, double prix, boolean ingredient) {
		this.nom = nom;
		this.prix = prix;
		this.ingredient = ingredient;
	}

}
