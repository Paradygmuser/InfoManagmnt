package enael.eafc;

import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;

public class Entrepot {
	private TreeSet<Transportable> stock = new TreeSet<Transportable>();
	private Random rand = new Random();
	
	public Entrepot(int nombreTransportableEnRaypnOut) {
		preparerStock(nombreTransportableEnRaypnOut);
	}
	
	public void preparerStock (int nombreTransportableEnRayonOut) {
		for(int i=0;i<nombreTransportableEnRayonOut;i++) {
			
			TypeTransportable[] types = TypeTransportable.values(); // je range les valleur des enum dans un tableau
			TypeTransportable typeChoisi = types[rand.nextInt(types.length)]; // je choisi un type au hazar
			
			if(typeChoisi.equals(TypeTransportable.PALETTE)) {
				String plaque ="PAL-"+rand.nextInt(1000, 9000);
				stock.add( new Transportable(typeChoisi, plaque, 600));
			}
			else if(typeChoisi.equals(TypeTransportable.LMPV)) {
				String plaque ="LMPV-"+rand.nextInt(1000, 9000); 
				int poidaleatoire = rand.nextInt(600, 4001);//vehicule leger entre 600 et 4000 kg maximum
				stock.add( new Transportable(typeChoisi, plaque, poidaleatoire));
			}
			else if(typeChoisi.equals(TypeTransportable.LAV)) {
				int poidaleatoire = rand.nextInt(4000, 10001);//vehicule leger entre 4000 et 10000kg maximum
				String plaque ="LAV-"+rand.nextInt(1000, 9000);
				stock.add( new Transportable(typeChoisi, plaque, poidaleatoire));
			}
			else if(typeChoisi.equals(TypeTransportable.MBT)) {
				int poidaleatoire = rand.nextInt(10000, 32001);//vehicule leger entre 10 000 et 32 000 maximum
				String plaque ="MBT-"+rand.nextInt(1000, 9000);
				stock.add( new Transportable(typeChoisi, plaque, poidaleatoire));
			}
		}
	}
	
	public TreeSet<Transportable> getStock() {
		return stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rand, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrepot other = (Entrepot) obj;
		return Objects.equals(rand, other.rand) && Objects.equals(stock, other.stock);
	}	
}
