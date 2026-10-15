package enael.eafc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.TreeSet;

public class GestionnaireCommande {
	private int nbreCommande;
	private Random rand = new Random();
	private int MenuLength = MenuPizza.values().length;
	private int StatutLength = CommandeStatuts.values().length;

	private TreeSet<Commande> commandes = new TreeSet<>();
	
	public GestionnaireCommande(int nbreCommande) {
		this.nbreCommande=nbreCommande;
		//je vais forcer le systeme pour faire semblant qu'il y a plusieur commandes deja presente.
		instancierCommande();
	}
	
	public void instancierCommande() {
		for(int i=0; i<nbreCommande;i++) {
			MenuPizza pizzaI = MenuPizza.values()[rand.nextInt(MenuLength)];
			CommandeStatuts statutI = CommandeStatuts.values()[rand.nextInt(StatutLength)];
			commandes.add(new Commande(pizzaI, statutI));
		}
	}
	//ou bien rajouter une commande manuellement
	
	public void ajouterCommande(MenuPizza pizza, CommandeStatuts statut) {
		if(nbreCommande<998) {
			commandes.add(new Commande(pizza, statut));
		}
		else {
			System.out.println("le systeme de gestion ne peut prendre plus de 999 commandes");
		}		
	}
	
	//changer le statu d'une commande si on saisie un string en console
	public void changerStatutCommande(String id, CommandeStatuts statut) {
		for(Commande c: commandes) {
			if(c.getCommandeId().equals(id)) {
				c.setStatut(statut);
			}
		}		
	}
	
	public void afficherCommandesParId() {
		for(Commande c: commandes) {
			System.out.println(c.getCommandeId()+" "+c.getPizza()+" "+c.getStatut());
		}
	}
	
	public void afficherCommandeParStatut() {
		TreeSet<Commande> SetCommandeStatut = new TreeSet<Commande>(new TrierParStatutCommande());
		SetCommandeStatut.addAll(commandes);
		for(Commande c : SetCommandeStatut) {
			System.out.println(c.getCommandeId()+" "+c.getPizza()+" "+c.getStatut());
		}
	}
	
	public void afficherCommandeEnCours() {
		for(Commande c : commandes) {
			if(c.getStatut().equals(CommandeStatuts.EN_COURS)) {
				System.out.println(c.getCommandeId()+" "+c.getPizza()+" "+c.getStatut());
			}
		}
	}
	
	public void ecrirFichierLog() {
		TreeSet<Commande> commandeAnnulees = new TreeSet<Commande>();
		for(Commande c : commandes) {
			if(c.getStatut().equals(CommandeStatuts.ANNULER)) {
				commandeAnnulees.add(c);
			}
		}
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("log_commande_annulee.txt"))) { 
			for(Commande c : commandeAnnulees) {
				bw.write(
						"la commande numero: "+c.getCommandeId()+ 
						" n'a pas pu etre realiser car il manque des ingredient pour faire la pizza "+c.getPizza());
				bw.newLine();				
			}
			//le fichier se trouvera dans le dossier du projet, 
			//il sera ecraser a chaque fois qu'on lance le programme, 
			//on peut le concatainer pour eviter ca ou lui donner un id, mais c'est pas le but de l'exercice.
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
