package eaf.enael;

public class Van extends Vehicule {

	public Van() {
		this.poid = 1500; // comme les attribut sont en proteger dans la classe vehicule, et que le constructeur de vehicule qui appelera le constructeur de van definira pour les attribut ce poid et ce place.
		this.place = 2;
	}
	// privé pour eviter que les propriété de base du van soit modifié. ainsi personne ne triche a l'entré du Ferry.
	public String jeSuis() {
		return "Van";
	}

}
