import java.util.Comparator;

public class VolumeComparator implements Comparator<Chargeable>{

	@Override
	public int compare(Chargeable c1, Chargeable c2) {

		return Double.compare(c1.getVolume(), c2.getVolume());
	}

}
