package eu.eafcevere.ship2025;

import java.util.Comparator;

public class ChassisComparator implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return o1.chassis.compareTo(o2.chassis);
	}

}
