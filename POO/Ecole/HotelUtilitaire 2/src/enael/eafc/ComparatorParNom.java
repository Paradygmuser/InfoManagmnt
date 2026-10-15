package enael.eafc;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeSet;

public class ComparatorParNom implements Comparator<Personne>{

	@Override
	public int compare(Personne o1, Personne o2) {
		if(o1.getNom().equals(o2.getNom())) {
			return o1.getPrenom().compareTo(o2.getPrenom());
		}
		else {
			return o1.getNom().compareTo(o2.getNom());
		}
	}
}
