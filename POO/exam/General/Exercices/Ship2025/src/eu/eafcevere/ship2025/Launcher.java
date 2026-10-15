package eu.eafcevere.ship2025;

public class Launcher {

	public static void main(String[] args) {
		Ship ship = new Ship();
		Vehicle v = new Car("ABC","Opel","Black",200000);
		Vehicle v1 = new Car("ABB","Mercedes","Black",3000);
		Vehicle v2 = new Car("BBC","Opel","Orange",150);
		Vehicle v3 = new Car("CBB","Opel","White",120000);
		Vehicle v4 = new Car("ABX","BMW","White",3);
		Vehicle v5 = new Car("ABXA","Alfa","White",300000);
		Vehicle v6 = new Car("ABZ","BMW","White",30000);
		Vehicle v7 = new Car("BBX","BMW","White",39000);
		
		boolean ajout = ship.addVehicle(v);
		boolean ajout1 = ship.addVehicle(v1);
		boolean ajout2 = ship.addVehicle(v2);
		boolean ajout3 = ship.addVehicle(v3);
		boolean ajout4 = ship.addVehicle(v4);
		boolean ajout5 = ship.addVehicle(v5);
		boolean ajout6 = ship.addVehicle(v6);
		boolean ajout7 = ship.addVehicle(v7);
		
		System.out.println(ship.afficherVehiculesParKM());
	}

}
