package be.eafc.marwan;

import java.util.Comparator;

public class ComparatorParId implements Comparator<Chargeable> {

	@Override
	public int compare(Chargeable o1, Chargeable o2) {
		// TODO Auto-generated method stub
		return o1.getId().compareTo(o2.getId());
	}

}
