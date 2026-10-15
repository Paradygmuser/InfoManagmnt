package enael.eafc;

import java.util.Date;

public class Etudiant implements Comparable<Etudiant>{
	private String nom ;
	private String prenom;
	private int idEtudiant;
	private static int idCompteur = 0; // comme dans l'exercice des billet, nous avons besoin d'un compteur qui garde la meme adresse memoire dans le stack.
	private Date naissance;
	
	public Etudiant(String nom, String prenom/*, Date naissance*/) {
		this.nom=nom;
		this.prenom=prenom;
		this.naissance=naissance;
		setId();		
	}

	public void setId() {
		idEtudiant = idCompteur +1; // car le compteur est a zero , je rajoute un pour avoir un id qui commence à un j'aurais pu le mettre a 1
		idCompteur ++;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}
	
	
	@Override
	public int compareTo(Etudiant o) {
		
		int i= this.nom.compareTo(o.nom);
		if(i==0) {
			return this.prenom.compareTo(o.prenom); // si 0 correspond à égale lors du compareTo alors classe par prenom car le nom est le meme
		}
		else {
			return i;
		}
		
		
	}

	
	
	
	
	

}
