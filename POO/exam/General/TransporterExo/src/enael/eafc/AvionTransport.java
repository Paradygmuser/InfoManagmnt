package enael.eafc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Path;
import java.util.*;
public class AvionTransport implements Comparable<AvionTransport> {
	private static int compteur=0;
	private String matricule;
	private int poidMax =35000 ;
	private int placeMax = 32; 
	private int poidActuel;
	private int placePrise;
	
	//constructeur
	public AvionTransport() {
		compteur++;
		this.matricule = "CT-"+compteur;
	}
	
	//raccourci eclipse
	@Override
	public String toString() {
		return "AvionTransport [matricule=" + matricule +
				", charge actuel ="+ poidActuel+ ", Place Prise ="+ placePrise+
				", PoidRestant ="+ (poidMax-poidActuel) + ", places restantes= "+ (placeMax-placePrise)+ 
				", poidMax=" + poidMax + ", place maximum=" + placeMax;
	}	
	
	public EtatAvion getEtatAvion() {
		if(poidActuel ==0 && placePrise ==0) {
			return EtatAvion.VIDE;
		}
		else if(poidActuel == poidMax || placePrise == placeMax) {
			return EtatAvion.FULL;
		}
		else {
			return EtatAvion.ENPARTIE;
		}
	}

	public String getMatricule() {
		return matricule;
	}

	public int getPoidMax() {
		return poidMax;
	}

	public int getNbPlace() {
		return placeMax;
	}
	
	public int getPoidActuel() {
		return poidActuel;
	}
	public int getPlacePrise() {
		return placePrise;
	}
	public void setPoidActuel(int poidActuel) {
		this.poidActuel = poidActuel;
	}
	public void setPlacePrise(int placePrise) {
		this.placePrise = placePrise;
	}	

	@Override
	public int hashCode() {
		return Objects.hash(matricule, placeMax, placePrise, poidActuel, poidMax);
	}	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvionTransport other = (AvionTransport) obj;
		return Objects.equals(matricule, other.matricule) && placeMax == other.placeMax
				&& placePrise == other.placePrise && poidActuel == other.poidActuel && poidMax == other.poidMax;
	}

	//trie par defaut
	

	@Override
	public int compareTo(AvionTransport o) {
		// TODO Auto-generated method stub
		return this.matricule.compareTo(o.getMatricule());
	}
}
