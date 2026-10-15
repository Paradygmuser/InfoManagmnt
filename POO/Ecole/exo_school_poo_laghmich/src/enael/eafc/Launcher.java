package enael.eafc;

public class Launcher {

	public static void main(String[] args) {
		School s1 = new School("Institu-Saint-Vincent-De-Paul", 3, 30);

		s1.listerEtudiant("Dubois", "Rachid"/*, 29121988*/);
		s1.listerEtudiant("Bah", "ahmadou"/*, 29121988*/);
		s1.listerEtudiant("DuJardin", "Anneke"/*, 29121988*/);
		s1.listerEtudiant("DuJardin", "Jean"/*, 29121988*/);
		s1.listerEtudiant("Dupont", "Elodie"/*, 29121988*/);
		s1.listerEtudiant("Zinedine", "Zidane"/*, 29121988*/);
		s1.listerEtudiant("Roberto", "Carlos"/*, 29121988*/);
		s1.afficheEtudiantParNom();
		System.out.println();
		s1.afficheEtudiantParId();

	}

}
