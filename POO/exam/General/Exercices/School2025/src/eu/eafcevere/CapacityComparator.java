package eu.eafcevere;

import java.util.Comparator;

public class CapacityComparator implements Comparator<Room>{

	@Override
	public int compare(Room o1, Room o2) {
		if(o1.getCapacity()==o2.getCapacity()) {
			return o1.getId()-o2.getId();
		}
		return o1.getCapacity()-o2.getCapacity();
	}

}
