package enael.eafc;


public class HotelMainOut {
	/**
	 * Nous allons modéliser les premières étapes d’un logiciel de gestion d’hôtel.
	 * La « Map » est imposée comme structure de données pour les chambres et personnes.
	 * ✅ U-2713
	 * Une chambre/suite comporte 
	 * ✅ un identifiant unique, 
	 * ✅ un étage, 
	 * ✅ une catégorie (LUXE, GRAND_LUXE, IMPERIAL), 
	 * ✅ un nombre maximum de personnes et une description.
	 * ✅ Chaque chambre/suite peut accueillir des personnes. 
	 * 
	 * Chaque personne est identifiée par 
	 * ✅un numéro de registre national, 
	 * ✅un nom, un prénom 
	 * ✅et une date de naissance.
	 * 
	 * ✅ L’utilisateur doit pouvoir ajouter des chambres.
	 * ✅ Une personne doit pouvoir être ajouté à une chambre déjà existante.
	 * ✅ Une exception ChambreFullException doit être lancée si on essaie d’ajouter plus de personnes que le maximum par chambre.
	 *  +/- Comparator non verifier L’hôtel doit pouvoir fournir le nombre de personnes.
	 * +/- L’hôtel doit pouvoir donner la liste des personnes, triées par chambre ou trié par nom de famille. 
	 * ✅ +/- Comparator L’hôtel doit pouvoir donner la liste des personnes qui ont moins de 18 ans, triée par nom de famille.
	 * 
	 * Créez un Singleton utilitaires qui imprime à la console les différents retours de méthodes. 
	 * Commentez (JavaDoc) uniquement les éléments qui font de votre classe un Singleton.
	 * Créez une classe Test (JUnit) et testez que votre Singleton est bien un Singleton (une seule méthode à tester).
	 * 
	 */

	public static void main(String[] args) {
		UtilitaireSingleton s1 = UtilitaireSingleton.getInstance();

		 Chambre c1 = new Chambre(Categorie.GRAND_LUXE, 20, 8);
		 Chambre c2 = new Chambre(Categorie.LUXE, 10, 3);
		 Chambre c3 = new Chambre(Categorie.IMPERIAL, 27, 16);
		
		 Personne p1 = new Personne("Ishuguro", "Yoji    ", "29/12/1988");
		 Personne p2 = new Personne("Ackerman", "Mikassa ", "18/12/1990");
		 Personne p3 = new Personne("Einer   ", "Thorfinn", "20/03/2018");
		 Personne p4 = new Personne("Einer   ", "Arlette ", "29/04/2010");
		 Personne p5 = new Personne("Onizuka ", "Eikishi ", "05/09/1988");
		 Personne p6 = new Personne("Vegapunk", "Stella  ", "01/05/1990");
		 Personne p7 = new Personne("Tyson   ", "Mike    ", "30/11/2020");
		 Personne p8 = new Personne("Zelda   ", "viviane ", "13/07/1998");
		 
		 
		 s1.ajouterDesChambre(c1, c2, c3);
		 s1.ajouterUnePersonneChambre(c1, p5, p2, p4);
		 s1.ajouterUnePersonneChambre(c2, p1, p6, p3, p5, p6);
		 s1.ajouterUnePersonneChambre(c3, p7, p8);
		 
		 s1.listerPersonneParChambre();
		 s1.listerPersonneParNom();
		 s1.listerMoinDe18();
	}

}
