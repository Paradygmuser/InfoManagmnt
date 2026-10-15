package src;
import java.util.Comparator;

public class PoidsComparator implements Comparator<Materiel>{

	@Override
	public int compare(Materiel c1, Materiel c2) {

		return c1.getPoids()-c2.getPoids();
	}

}
