package enael.eafc;

public class MainOutCommande {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionnaireCommande gestionnaire = new GestionnaireCommande(50);
		
		//gestionnaire.afficherCommandeParStatut();
		gestionnaire.afficherCommandeEnCours();
		//gestionnaire.afficherCommandesParId();
		//test git git hit hit
		gestionnaire.ecrirFichierLog();

	}

}
