package enael.eafc;

import java.util.Objects;

public class Student implements Comparable<Student> {	
	private static int compteurID;
	private  int id ;
	private String nom;
	private String prenom;
	private String classe;
	private int moyenneGeneral;	
	public Student( String nom, String prenom, String classe) {
		this.nom=nom;
		this.prenom=prenom;
		this.classe=classe;		
		attribuerID();
	}
	private void attribuerID() {
		this.id=compteurID;
		compteurID++;		
	}
	public int getMoyenneGeneral() {
		return moyenneGeneral;
	}
	public void setMoyenneGeneral(int moyenneGeneral) {
		this.moyenneGeneral = moyenneGeneral;
	}
	//si on veut changer de classe d'un etudiant
	public void setClasse(String classe) {
		this.classe = classe;
	}
	//pour le trie par nom prenom et classe
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return id-o.id; // triage par default : l'id devrait etre unique donc on le soustrait à l'id suivant, si l'id suivant est plus grand il sera apres, l'id est plus petit il sera avant
	}
	
	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getClasse() {
		return classe;
	}
	public int getId() {
		return id;
	}
	//pour afficher les donner complete
	@Override
	public String toString() {
		return "Student [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", classe=" + classe + ", moyenne="+moyenneGeneral+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(classe, id, nom, prenom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(classe, other.classe) && id == other.id && Objects.equals(nom, other.nom)
				&& Objects.equals(prenom, other.prenom);
	}
}
