package enael.eafc;
import java.util.*;
import java.util.Map.Entry;

public class School {
	Map <Student,TreeSet<Examen>> students = new TreeMap<Student,TreeSet<Examen>>();	
	public void ajouterStudent( String nom, String prenom, String classe) {
		TreeSet<Examen> examen = new TreeSet<Examen>();		
		switch (classe) {
		case "1BACINFO": {
			examen.add(new Examen(Exam.StructureOrdi));	
			examen.add(new Examen(Exam.GestionBD));
			examen.add(new Examen(Exam.PrincipeAlgo));
			examen.add(new Examen(Exam.PrincipeAna));
			examen.add(new Examen(Exam.InitBD));
			examen.add(new Examen(Exam.BaseReseau));
			examen.add(new Examen(Exam.BaseWeb));
			break;
		}
		case "2BACINFO": {
			examen.add(new Examen(Exam.OperatSys));	
			examen.add(new Examen(Exam.GestionProjet));
			examen.add(new Examen(Exam.PrograOO));
			examen.add(new Examen(Exam.Statistique));
			examen.add(new Examen(Exam.PrincipeAnalysEtConception));
			examen.add(new Examen(Exam.ProjetWEB));
			break;
		}		
		default:
			throw new IllegalArgumentException("Unexpected value: " + classe);
		}	
		
		students.put(new Student(nom,prenom,classe),examen);
	}	
	public Student recupererStudent(int id) {
		Set<Student> set = students.keySet();
		for(Student s : set) {
			if(s.getId()==id) {
				return s;
			}
			else {
				continue;
			}
		}
		//j'ai un peux chipoter mais je voulais pas faire des s1, s2, etc j'ai l'impression de faire deux fois le meme travail.
		return null;
		// je n'ai pas encor tester mais j'espere que grace a cette methode je pourrais recuper l'etudiant que par son id.
	}
	public void ajouterExam(int idEtudian, Exam ...exam ) {
		Student s = recupererStudent(idEtudian);
		TreeSet<Examen> setExam = students.get(s);
		for(Exam e: exam) {
			setExam.add(new Examen(e));					
		}
		students.replace(s, setExam);
	}
	public void retirerExam(int idEtudian, Exam ...exam ) {
		Student s = recupererStudent(idEtudian);		
		TreeSet<Examen> lesexam = students.get(s);
		for(Exam e: exam) {
			students.remove(s, e);					
		}
	}
	public void attribuerNote(int idEtudian, Exam e, int note) {
		Student s= recupererStudent(idEtudian);
		TreeSet<Examen> ss = students.get(s);
		for(Examen examende : ss) {
			if(examende.id==e.getId()) {
				examende.setPoint(note);
			}
		}
		students.replace(s, ss);

		s.setMoyenneGeneral(calculerMoyenne(s.getId()));//calculer la moyenne apres avoir remplacer le set
	}
	
	public int calculerMoyenne(int idEtudian) {
		Student	s = recupererStudent(idEtudian);
		TreeSet<Examen> setExam = students.get(s);
		int n = setExam.size();// la note est sur 20 ou sur 100 ne change rien
		int somme = 0;
		for(Examen e: setExam ) {
			somme+=e.getPoint();
		}
		return somme/n;
	}
	
	public void afficherParClasse() {
		Set<Student> nouvelListeStud = new TreeSet<>( new TrieParClasse());
		nouvelListeStud.addAll(students.keySet());
	}
	
	
	
//	public void afficherParClasse() {		
//		Set<Student> ss = new TreeSet<Student>(new TrieParClasse());
//		ss.addAll(students.keySet()); // keySet retourne tout les etudiant dans un set ici trier par classe, ensuite par nom, puis prenom
//		for(Student s : ss) {
//			String [] sArray = students.get(s).toString().split("--");
//			System.out.println(s.toString());			
//			for(int a=0;a<sArray.length;a++) {
//				System.out.println("    "+sArray[a]);
//			}
//		}		
//	}
	
	public void afficherParNom() {		
		Set<Student> ss = new TreeSet<Student>(new TrieParNom());
		ss.addAll(students.keySet()); // keySet retourne tout les etudiant dans un set ici trier par classe, ensuite par nom, puis prenom
		for(Student s : ss) {
			String [] sArray = students.get(s).toString().split("--");
			System.out.println(s.toString());			
			for(int a=0;a<sArray.length;a++) {
				System.out.println("    "+sArray[a]);
			}
		}		
	}
	public void afficherParMoyenne() {		
		Set<Student> ss = new TreeSet<Student>(new TrieParMoyenne());//vide
		ss.addAll(students.keySet()); // keySet retourne tout les etudiant dans un set ici trier par classe, ensuite par nom, puis prenom
		for(Student s : ss) {
			String [] sArray = students.get(s).toString().split("--");
			System.out.println(s.toString());			
			for(int a=0;a<sArray.length;a++) {
				System.out.println("    "+sArray[a]);
			}
		}		
	}
	@Override
	public String toString() {
		return "School [students=" + students + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(students);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		return Objects.equals(students, other.students);
	}
}
