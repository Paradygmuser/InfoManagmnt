package enael.eafc;

import java.util.Comparator;

public class CompareridEtudiant implements Comparator<Etudiant>{

	@Override
	public int compare(Etudiant o1, Etudiant o2) {
		
		return o1.getIdEtudiant()-o2.getIdEtudiant();
	}

}
