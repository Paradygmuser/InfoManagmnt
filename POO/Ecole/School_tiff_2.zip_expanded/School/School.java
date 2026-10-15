package School;

import java.util.*; // tu me repoche de me casser la tete, mais toi c'est pire :) * veut dire TOUT


public class School {
	/*######LES ATTRIBUTS#######*/
	private String name; // juste lol
	// les SET : juste mais par vu ainsi en cours, ici, il faut donc bien un Set au départ, car il pourrait arriver qu'on dois melanger des HashSet et des TreeSet ensemble 
	
	//private Set<Student> student; private Set<Room> room;
	private Set<Student> students = new TreeSet<Student>();
	private Set<Room> rooms = new TreeSet<Room>();
	
	
	/*####LE CONSTRUCTEUR######**/
	//le constructeur, si je respecte ton code je vais respecter ton code et ne pas parler d'etage ou de chambre a attribuer
	// donc un constructeur sert à construir en dehor de part defaut donc , il faut d'office des parametre entre parenthese(on les apl les parametre formel à l'ecole)
	// par exemple lorsqu'on apl un constructeur grace au mot clef"new" on peut lui donner un parametre formel, comme ici le nom de l'ecole
	/*public School() {
        student = new HashSet<>();
        room = new HashSet<>();
    }*/	
	public School(String nomEcole) {
        this.name=nomEcole;
    }
	
	/*###LES METHODES FIEUX##*/
	//je comprend le prof a fait comme toi, mais je trouve ca trop hardcodeur, on aurait pu faire une variable statique mais on va garder comme ca tampis pour la culture.
	// j'ai juste rajouter un s a room de ton code original qui est l'attribut déclarer en debut de class School
	public void ajouterRoom(Room r) {
		
		rooms.add(r);
		
	}
	// j'ai juste rajouter un s a student de ton code original qui est l'attribut déclarer en debut de class School
	
	public void ajouterStudent (Student s) {
		
		students.add(s);
		
	}
	
	
	/*##LES METHODE DE TRIAGE###*/
	// le triage, est totalemnt just avec sort, il est meme conseiller de lfaire avec sort, mais bon on est dans l'ecole des anciens
	// donc , le triage ce fait soit par l'apl de l'interface Comparable ou par une instance de Comparator/
	// quand on utilise "omplements Comparable", c'est comme si on donne un ordre de trie par defaut pour cette methode
	//qui n'apl pas d'instance de comparator , comprend tu ? 
	// il y a un tri par default qui est fait grace à l'interface comparable et un trie custom fait par un comparator.
	
	// donc afficher etudiant par ID sera ton sort(triage) par default grace à l'interface Comparable appretenant à la classe Student
	/*
	public void afficherEtudiantsTriesParId() {
		
		List<Student> listeEtudiants = new ArrayList<>(student);
		listeEtudiants.sort(Comparator.comparing(Student::getId));
		
		for (Student s : listeEtudiants) {
			
			System.out.println(s);
		}
		
		//public void afficherEtudiantsTriesParId() {

	       // Set <Student> etudiantstrierparid = new TreeSet<>(new comparerStudId()); //creer une classe apart avec implement comparator
	        // etudianttrierparid.adAll(/ta liste declarer a la base de school "/

	        //for (Student s : etudiantstrierparid) {

	            //System.out.println(s); // avec tosting dans etudiant
	        //}
		
		
	}
	*/ /*c'est donc un simple affichage dans le trie par default*/
	
	public void afficherEtudiantsTriesParId() {
		for(Student s : students) {
			System.out.println(s); // je ne savais pas qu'on pouvait utilisé le toString pour ca donc je ne modifie pas ici
		}
	}
	public void afficherEtudiantsTriesParNomPrenom() {
		
		Set<Student> studentByName = new TreeSet<Student>(new comparatorNomEtudiant()); // donc ici on apl le constructeur lors de l'instance de TreeSet, qui va forcer a creer une nouvelle liste TreeSet dans l'ordre demander par comparator, la methode sort est effectivement la plus efficace car elle prend moin de place mémoir.
		studentByName.addAll(students); // on ajoute a cette nouvelle liste, la liste des etudiant ajouter par la methode ajouterEtudiant
		//pour chaque etudiant dans cette liste tu print
		for (Student s : studentByName) {
			
			System.out.println(s);
		}	
	}
	
	public void afficherLocauxsTriesParNumLoc() {
		
		List<Room> listeRooms = new ArrayList<Room>(); // pourquoi tu utilise ArrayListe alors qu e lprof donne cours sur les collection de type Set et Map? Array list c'est ce que j'utilisse aussi, mais le prof nous donne cours sur les Set, les prochain normlmnt c'est le map, mais je pense qu'on va pas le voir car tropc compliquer pour lui, genre on va jamais voir un seul tableau a plusieur dimenseion, ce qui rend la formation tres triste, tres b )  bas pour les assisté.
		listeRooms.sort(Comparator.comparing(Room::getNumloc));
		
		for (Room r : listeRooms) {
			
			System.out.println(r);
		}

		
	}

	public void afficherLocauxTriesParCapacity() {
		
		List<Room> listeRooms = new ArrayList<Room>(); // j'ai corriger la syntax, mais la classe et les methode lié a room n'ont pas été encor revu 
		listeRooms.sort(Comparator.comparing(Room::getCapacity));
		
		for (Room r : listeRooms) {
			
			System.out.println(r);
		}
	
}
	
		
	
	


	
	
	
	
	
	
	
}



