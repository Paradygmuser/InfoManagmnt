package exo3.enael;

public class Menage {
	// en dehor de l'identifiant qui sera repris dans housHold nous avons besoin que des deux attribut suivant
	//PS : le menage compose la classe HousHold, le tableau est composé de menage.
	private double revenuAnuel ;
	private int nmbrdePersonne;
	// pour directement mettre en tant qu'objet 
	//lors de l'appel du constructeur par le new les donnée souhaiter en dehor de l'identifiant
	
	public Menage(double a, int b) {
		this.revenuAnuel=a;
		this.nmbrdePersonne=b;
		
	}
}
