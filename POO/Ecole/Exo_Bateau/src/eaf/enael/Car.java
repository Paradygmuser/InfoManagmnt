package eaf.enael;

public class Car extends Vehicule {
	public Car () {
		this.poid = 1000; // le this pointe versl'heritage de propriété de la classe vehicule lorsqu'il est instensié.
		this.place = 1;
		
	}
	// privé pour eviter que les propriété de base du car soit modifié. ainsi personne ne triche a l'entré du Ferry.
	public String jeSuis() {
		return "Car";
	}
}
