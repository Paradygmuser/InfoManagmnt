package enael.eafc;

import java.util.Objects;

public class Transportable implements Comparable<Transportable> {
	//chaque transportable à un poid et un nombre de place
	private int place ;
	private int poid;
	
	//chaque transportable à un type et une plaque de matriculation non automatique (donc hardcoder?)
	private TypeTransportable typeMateriel;
	private String plaqueMatriculation;
	/*ÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓ*/
	private int ordreAjout; //pour etre sur que je peux les trié dans l'ordre d'ajout, je vais creer une variable attestant leur ordre.
	private static int compteurOrdreAjout=0;
	
	
	public Transportable (TypeTransportable typeMateriel, String PLaqueMatriculation, int poid) {
		compteurOrdreAjout++;
		this.ordreAjout = compteurOrdreAjout;
		this.plaqueMatriculation = PLaqueMatriculation;
		this.poid = poid;
		this.typeMateriel = typeMateriel;
		this.place = typeMateriel.getPlacePrise();		
	}
	
	//raccourci eclipse "source->generate..."
	
	public int getPlace() {
		return place;
	}	
	@Override
	public String toString() {
		return "Transportable [typeMateriel=" + typeMateriel + "]";
	}

	public int getPoid() {
		return poid;
	}
	public TypeTransportable getTypeMateriel() {
		return typeMateriel;
	}
	public String getPlaqueMatriculation() {
		return plaqueMatriculation;
	}
	public int getOrdreAjout() {
		return ordreAjout;
	}

	@Override
	public int compareTo(Transportable o) {
		//si c'est le meme type de materiel
		if(this.typeMateriel.equals(o.getTypeMateriel())) 
		{
		// si ils ont le meme poid
			if(this.poid == o.getPoid()) 
			{
				//alors retourne par ordre d'ajout
				return this.ordreAjout-o.getOrdreAjout(); // 
			}
			//sinon retourne par poid
			else 
			{
				return this.poid- o.getPoid();
			}
			
		}
		//Sinon de chez sinon retourn par type de mateiel	
		else 
		{
			return this.typeMateriel.compareTo(o.getTypeMateriel());
		}
		//return cmp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ordreAjout, place, plaqueMatriculation, poid, typeMateriel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transportable other = (Transportable) obj;
		return ordreAjout == other.ordreAjout && place == other.place
				&& Objects.equals(plaqueMatriculation, other.plaqueMatriculation) && poid == other.poid
				&& typeMateriel == other.typeMateriel;
	}
}
