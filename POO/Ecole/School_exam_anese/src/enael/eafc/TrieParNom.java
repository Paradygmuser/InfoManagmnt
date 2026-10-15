package enael.eafc;

import java.util.Comparator;

public class TrieParNom implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getNom().equals(o2.getNom())) {
			//si le nom son les meme return la valeur sur les prenom
			return o1.getPrenom().compareTo(o2.getPrenom());
		}
		
		return o1.getNom().compareTo(o2.getNom());
	}

}
