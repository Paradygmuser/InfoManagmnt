package eu.eafcevere.ship2025;

import java.util.Comparator;

public class ColorComparator implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		if(o1.color.equals(o2.color)) {
			return o1.chassis.compareTo(o2.chassis);
		}
		return o1.color.compareTo(o2.color);
	}

}
