package eu.eafcevere.ship2025;

import java.util.Comparator;

public class KMComparator implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		if(o1.km==o2.km) {
			return o1.chassis.compareTo(o2.chassis);
		}
		return o2.km-o1.km;
	}

}
