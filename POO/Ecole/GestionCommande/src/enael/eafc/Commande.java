package enael.eafc;

import java.util.Objects;

public class Commande implements Comparable<Commande> {
	private String commandeId;
	//imaginons que ca soit dans une UI où la liste de pizza est afficher 
	//et que la selection de pizza choisi bien le type Enum MenuPizza, 
	//alors on peut directement stocker le type Enum MenuPizza dans la classe Commande.
	//sinon on pourrai pour la console stocker le nom de la pizza et faire une methode pour convertir le nom en type Enum MenuPizza.
	//private String pizza; //si on stocke le nom de la pizza
	//private MenuPizza pizza; //si on stocke le type Enum MenuPizza
	private MenuPizza pizza;
	private CommandeStatuts statut;
	private static int compteurID=0;
	
	
	public Commande( MenuPizza pizza, CommandeStatuts statut) {
		this.pizza = pizza;
		this.statut = statut;
		getIDCommande();
	}
	
	private void getIDCommande() {
		compteurID++;
		if(compteurID<10) {
			this.commandeId = "PIZZ-00"+compteurID;
		}
		else if(compteurID<100) {
			this.commandeId="PIZZ-0"+compteurID;
		}
		//le systeme de gestion ne pourra prendre plus de 999 commandes.
		else {
			this.commandeId="PIZZ-"+compteurID;
		}
	}
	
	//nous trierons par default par orde de Id
	@Override
	public int compareTo(Commande o) {		
		return this.commandeId.compareTo(o.commandeId);
	}

	public String getCommandeId() {
		return commandeId;
	}

	public MenuPizza getPizza() {
		return pizza;
	}

	public CommandeStatuts getStatut() {
		return statut;
	}
	
	public void setPizza(MenuPizza pizza) {
		this.pizza = pizza;
	}

	public void setStatut(CommandeStatuts statut) {
		this.statut = statut;
	}

	@Override
	public int hashCode() {
		return Objects.hash(commandeId, pizza, statut);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return Objects.equals(commandeId, other.commandeId) && pizza == other.pizza && statut == other.statut;
	}

	@Override
	public String toString() {
		return "[commandeId=" + commandeId + ", pizza=" + pizza + ", statut=" + statut + "]";
	}	
	
	
}
