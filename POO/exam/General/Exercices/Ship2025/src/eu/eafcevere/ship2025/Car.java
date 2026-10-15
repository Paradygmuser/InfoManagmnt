package eu.eafcevere.ship2025;

public class Car extends Vehicle{

	public Car(String chassis, String marque, String color,int km) {
		super(chassis, marque, color,km);
	}

	@Override
	public int getPlaces() {
		return 1;
	}

	@Override
	public int getWeight() {
		return 1000;
	}

	@Override
	public int compareTo(Vehicle o) {
		if(this.marque.equals(o.marque)) {
			return this.chassis.compareTo(o.chassis);
		}else {
			return this.marque.compareTo(o.marque);
		}
	}

}
