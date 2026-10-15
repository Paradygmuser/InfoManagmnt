package enael.eafc;

import java.util.Comparator;

public class TrierParStatutCommande implements Comparator<Commande> {

	@Override
	public int compare(Commande o1, Commande o2) {
		if(o1.getStatut().equals(o2.getStatut())) {
			return o1.getCommandeId().compareTo(o2.getCommandeId());
		}
		else {
			return o1.getStatut().compareTo(o2.getStatut());
		}
	}
}
