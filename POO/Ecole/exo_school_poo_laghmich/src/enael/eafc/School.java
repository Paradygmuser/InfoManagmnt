package enael.eafc;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class School {
	private String name ;
	/* je n'avais pas compris pourquoi on polymorphait TreeSet en Set ou HashSet en class lors l'exo sur le bateau, 
	mais ca serait pour avoir les methode removelast et addAll? j'ai verifier ainsi et j'ai quand meme acces au methodes */
	private TreeSet <Etudiant> listeEtudiant = new TreeSet<Etudiant>();
	private TreeSet <Room> listeLocaux = new TreeSet<Room>();
	// EXTRA l'enoncé nous dit pas combien d'etage ou de locaux, du coup on va les construire a partir du launcher
	private int nbrEtage; // explication dans la methode ROOM, je peux l'expliquer en classe si besoin
	private int locauxParEtage;
	//private int nbrEtudiant;
	public School(String name, int nbrEtage, int locauxParEtage/*,int nbreEtudianInscrit*/) {
		this.name=name;
		this.nbrEtage=nbrEtage;
		this.locauxParEtage= locauxParEtage;
		//this.nbrEtudiant=nbreEtudianInscrit;
		//creerLocaux();
	}

	public void creerLocaux() {
    	for (int a= 0; a<nbrEtage; a++) {
    		for(int i=0;i<locauxParEtage;i++) {    		
        		listeLocaux.add(new Room(a,i)); // on compose l'ecole de classe normalnt le a le numero d'etage et le i le numero de la classe
        	}
    	}	
	}
    
    public void listerEtudiant(String nom, String prenom/*, Date naissance*/) {
    	//for (int a=0; a<nbrEtudiant; a++) {
    		listeEtudiant.add(new Etudiant(nom, prenom/*, naissance*/));
    	//}
    }
    

	public void afficheEtudiantParNom(){
		//TreeSet<Etudiant> newlist = new TreeSet<Etudiant>();
		for(Etudiant e : listeEtudiant) {
			
			System.out.println(e.getNom()+" "+e.getPrenom()+"-"+e.getIdEtudiant());		
		}
		
	}
	
	public void afficheEtudiantParId(){
		TreeSet<Etudiant> newlist = new TreeSet<Etudiant>(new CompareridEtudiant()); // pour lister par id il faut instancié le comparator dans la liste
		newlist.addAll(listeEtudiant);
		for(Etudiant e : newlist) {
			
			System.out.println(e.getIdEtudiant()+"-"+e.getNom()+" "+e.getPrenom());		
		}
		
	}

	
	
	
	
	

}
