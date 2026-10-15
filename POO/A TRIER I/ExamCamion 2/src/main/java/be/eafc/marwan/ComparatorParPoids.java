package be.eafc.marwan;

import java.util.Comparator;

public class ComparatorParPoids implements Comparator<Chargeable> {

	@Override
	public int compare(Chargeable o1, Chargeable o2) {
		// TODO Auto-generated method stub
		return Double.compare(o1.getPoids(), o2.getPoids());
	}

}
