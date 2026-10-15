package enael.eafc;

import java.util.Scanner;

public class Menu {
	Affichage affiche = new Affichage();
	public void menuPrincipal(School s, Scanner scan) {
		boolean choixbool = true;
		while(choixbool) {
			menuText();
			int choix = scan.nextInt();
			switch (choix) {
			case 1: {
				menueAjouterStudent(s,scan);
				break;
			}
			case 2: {
				menuAjouterExam(s,scan);
				break;
			}
			case 3: {
				menuRetirerterExam(s,scan);
				break;
			}
			case 4: {
				menuAttribuerNote(s,scan);
				break;
			}
			case 5: {
				menueAfficherParNom(s,scan);
				break;
			}
			case 6: {
				menueAfficherParClasse(s,scan);
				break;
			}

			case 7: {
				menueAfficherParMoyenneG(s,scan);
				break;
			}
			case 0 :
				System.out.println("Merci de nous avoir essayer au revoir");
				choixbool = false;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choix);
			}			
		}		
	}
	
	private void menueAfficherParMoyenneG(School s, Scanner scan) {
		// TODO Auto-generated method stubAffichage affiche = new Affichage();
		
		System.out.println();
		affiche.afficher("AFFICHER PAR MOYENNE");
		s.afficherParMoyenne();
		
		
	}

	private void menueAfficherParClasse(School s, Scanner scan) {
		System.out.println();
		affiche.afficher("AFFICHER PAR CLASS");
		s.afficherParClasse();
		
	}

	private void menueAfficherParNom(School s, Scanner scan) {
		System.out.println();
		affiche.afficher("AFFICHER PAR NOM, PRENOM");
		s.afficherParNom();
		
	}

	public void menuText() {
		System.out.println("tant que vous ne fermez pas le programme aucune donnée ne sera perdu, le contraire tout sera perdu, si votre choix est zero vous quittez le programme");
		System.out.println("nom des classe : 1BACINFO et 2BACINFO, aucun test ne sont fait sur le program pour verifé les caracteres");
		System.out.println("nom des raccourci des cours : POO,WB,PW,GEBD,IBD,PAN,PAL,PAC,TGP,SO,SE,ES, etc voir Enum Exam");
		System.out.println("Pour le test, il impératif rajouter un étudiant en premier lieu \n,puis afficher par une ordre qui vouplait pour notez sont id\n(je n'ai pas fait à la base par nom et prenom mais par id\n puis lui retirer un examen si il est dispensé, ou lui rajouter un examen de rattrpage de la classe inferieur ou supérieur\nAttribuer lui une note si besoin");
		for(int i= 0; i<64;i++) {
			System.out.print("#");
		}
		System.out.println();
		System.out.println("1. Ajouter un etudiant");
		System.out.println("2. ajouter examen à un etudiant");
		System.out.println("3. retirer un examen à un etudiant");
		System.out.println("4. attribuer note d'un examen à un etudiant");
		System.out.println("5. afficher etudiants par nom et prenom");
		System.out.println("6. afficher etudiants par classe");
		System.out.println("7. afficher etudiants par Moyenne general");
		System.out.println();
		System.out.print("choisir option numero : ");
	}
	
	public void menueAjouterStudent(School s, Scanner scan) {		
		boolean ajouteretudiant = true;
		while(ajouteretudiant==true) {
			System.out.println("Menu Ajouter etudiant, ordre d'entrée nom,prenom,classe");
			
			String nom = scan.next();
			String prenom = scan.next();
			String classe = scan.next();
			s.ajouterStudent(nom, prenom, classe);
			System.out.print("Avez-vous fini?(y/n) : ");
			String choix = scan.next();
			if(choix.equals("y")) {
				ajouteretudiant=false;
			}			
		}		
		
	}
	public void menuAttribuerNote(School s, Scanner scan) {
		boolean attribuer = true;
		while(attribuer==true) {
			System.out.println("Menu Attribuer Note à etudiant, ordre d'entrée id etudiant,raccourci exam, point");
			int id  = scan.nextInt();
			String examen = scan.next();
			int point  = scan.nextInt();
			Exam [] e = Exam.values();
			Exam ee = null;
			for(int i=0;i<e.length;i++) {
				if(e[i].getRaccourci().equals(examen)) {
					ee=e[i];
				}
				else {
					continue;
				}				
			}			
			s.attribuerNote(id, ee, point);
			System.out.print("Avez-vous fini?(y/n) : ");
			String choix = scan.next();
			if(choix.equals("y")) {
				attribuer=false;
			}			
		}
		
	}
	public void menuAjouterExam(School s, Scanner scan) {
	boolean ajouterExam = true;
	    while(ajouterExam==true) {
		    System.out.println("Menu Ajouter un examen à etudiant, ordre d'entrée id etudiant,raccourci exam, un examen à la fois");
		    int idEtudiant  = scan.nextInt();
		    String examen = scan.next();
		    Exam [] e = Exam.values();
	    	Exam ee = null;
    		for(int i=0;i<e.length;i++) {
     			if(e[i].getRaccourci().equals(examen)) {
	    			ee=e[i];
	     		}
    		    else {
	      			continue;
 	    		}				
	    	}			
		    s.ajouterExam(idEtudiant, ee);
		    System.out.print("Avez-vous fini?(y/n) : ");
		    String choix = scan.next();
		    if(choix.equals("y")) {
			    ajouterExam=false;
		    }			
	    }
	}
	
	public void menuRetirerterExam(School s, Scanner scan) {
		boolean ajouterExam = true;
		while(ajouterExam==true) {
			System.out.println("Menu Retirer un examen à etudiant, ordre d'entrée id etudiant,raccourci exam, un examen à la fois");
			int idEtudiant  = scan.nextInt();
			String examen = scan.next();
			Exam [] e = Exam.values();
			Exam ee = null;
			for(int i=0;i<e.length;i++) {
				if(e[i].getRaccourci().equals(examen)) {
					ee=e[i];
				}
				else {
					continue;
				}				
			}			
			s.retirerExam(idEtudiant, ee);
			System.out.print("Avez-vous fini?(y/n) : ");
			String choix = scan.next();
			if(choix.equals("y")) {
				ajouterExam=false;
			}			
		}
	}
}

