package enael.eafc;

public class Mainoutput {
/*
 * Imaginon un entrepot militaire qui stocke des vehicules et du materiel aevc un nombre variable de materiel a chaque programme.
 * */
	public static void main(String[] args) {
		GestionnaireAvion gestionnaire = new GestionnaireAvion (50); // entrepot avec 50 transportables
		AvionTransport at1 = new AvionTransport();
		gestionnaire.afficherAvionEtContenant();
	}
}
