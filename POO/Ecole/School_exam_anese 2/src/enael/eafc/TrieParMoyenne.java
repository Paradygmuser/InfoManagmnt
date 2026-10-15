package enael.eafc;

import java.util.Comparator;

public class TrieParMoyenne implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		//si meme moyyenne alors 
		if(o1.getMoyenneGeneral()==o2.getMoyenneGeneral()) {
			//check si le meme nom alors 
			if(o1.getNom().equals(o2.getNom())) {
				return o2.getPrenom().compareTo(o1.getPrenom());
			}
			//sinon par nom 
			else {
				return o2.getNom().compareTo(o1.getNom());
			}
		}
		return o2.getMoyenneGeneral()-o1.getMoyenneGeneral(); //malheuresement il est 21 heur je ne sais plus si c des int ou double ou float...
	}

}
