package eaf.enael;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Port liste = new Port(55); // je choisi arbitrairement de creer 25 fois des camionette et des voiturette.
		Ship leFerry =  new Ship(liste.getListeDemande()); // voir le constructeur dans la classe ship pour explication
		
		System.out.println(leFerry.getContent());
	}
}
