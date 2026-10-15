package eu.eafcevere.ship2025;

public class Van extends Vehicle{

	public Van(String chassis, String marque, String color,int km) {
		super(chassis, marque, color,km);
	}

	@Override
	public int getPlaces() {
		return 2;
	}

	@Override
	public int getWeight() {
		return 1500;
	}

	@Override
	public int compareTo(Vehicle o) {
		return this.marque.compareTo(o.marque);
	}

}
