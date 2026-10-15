package School;

import java.util.Comparator; // donc ici on apl ce fameux comparator qui n'a rien a voir avec un comparable, comparator permet de faire un tri custom
// ET C'EST CE QU'ON A VU EN COURS
public class comparatorNomEtudiant implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// si le nom est le meme trie par prenom
		if(o1.getLastname().equals(o2.getLastname())) {
			return o1.getName().compareTo(o2.getName()); // donc si ils ont le meme nom tri par prenom, le tri si ca t'interesse, on parle de trié des noeud dans une liste, chaque element est un noeud, si le precedent doit etre en premier, on lui donne -1 , et vice versa, si ils sont les meme ca donne 0 donc les valeur possible de cette methode sont 1, -1, et 0
		}
		else {
			return o1.getLastname().compareTo(o2.getLastname()); // sinon tu trie par nom de famille stp
		}
		
	}

}
