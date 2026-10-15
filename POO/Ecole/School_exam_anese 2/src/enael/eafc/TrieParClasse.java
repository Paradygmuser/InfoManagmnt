package enael.eafc;
import java.util.Comparator;
public class TrieParClasse implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
//si meme classe tri par nom , si meme nom trie par prenom
		if(o1.getClasse().equals(o2.getClasse())) {
			//si meme nom compar par prenom sinon par nom de la meme Classes
			if(o1.getNom().equals(o2.getNom())) {
				return o1.getPrenom().compareTo(o2.getPrenom());
			}
			else {
				return o1.getNom().compareTo(o2.getNom());
			}
		}
		return o1.getClasse().compareTo(o2.getClasse());
	}
}
