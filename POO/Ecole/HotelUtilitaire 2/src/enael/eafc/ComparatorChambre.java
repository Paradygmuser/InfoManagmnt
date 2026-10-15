package enael.eafc;

import java.util.Comparator;

public class ComparatorChambre implements Comparator<Chambre>{

	@Override
	public int compare(Chambre o1, Chambre o2) {
		// TODO Auto-generated method stub
		return o1.getIdentifiant().compareTo(o2.getIdentifiant());
	}

}
