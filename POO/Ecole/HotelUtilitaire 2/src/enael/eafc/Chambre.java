package enael.eafc;

import java.util.Objects;

public class Chambre implements Comparable<Chambre> {
	private static int compteurID=0;
	private String identifiant ;
	private int etage;
	private Categorie categorieChambre;
	private int nbrMaxPersonne;
	
	public Chambre(Categorie categorieChambre, int etage, int nbrMaxPersonne) {
		genererIdUnique(); // pour faire simple je met cette methode dans la classe Chambre
		this.categorieChambre=categorieChambre;
		this.etage=etage;
		this.nbrMaxPersonne=nbrMaxPersonne;				
	}
	
	public void genererIdUnique() {
		compteurID++;
		if(compteurID<10) {
			identifiant="CHBR-00"+compteurID;
		}
		else if(compteurID<100 && compteurID>9) {
			identifiant="CHBR-0"+compteurID;
		}
		else if(compteurID<1000 && compteurID>99) {
			identifiant="CHBR-"+compteurID;
		}
	}
	
	public boolean peuxAccueillir(int nbrPersonne) throws ChambreFullException {
		if(nbrPersonne>nbrMaxPersonne) {
			throw new ChambreFullException();
		}
		else {
			return true;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(categorieChambre, etage, identifiant, nbrMaxPersonne);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chambre other = (Chambre) obj;
		return categorieChambre == other.categorieChambre && etage == other.etage
				&& Objects.equals(identifiant, other.identifiant) && nbrMaxPersonne == other.nbrMaxPersonne;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public int getEtage() {
		return etage;
	}

	public Categorie getCategorieChambre() {
		return categorieChambre;
	}

	public int getNbrMaxPersonne() {
		return nbrMaxPersonne;
	}

	@Override
	public String toString() {
		return "Chambre : " + identifiant + "\n, etage : " + etage + "\n, categorieChambre : " + categorieChambre
				+ "\n, nbrMaxPersonne : " + nbrMaxPersonne ;
	}

	@Override
	public int compareTo(Chambre o) {
		// TODO Auto-generated method stub
		return this.identifiant.compareTo(o.identifiant);
	}
}
