package enael.eafc;

import java.util.Comparator;

public class ComparatorMaterielPoid implements Comparator<ChargeableMaterial> {

	@Override
	public int compare(ChargeableMaterial o1, ChargeableMaterial o2) {
		if(o1.getPoid()==o2.getPoid()) {
			return o1.getVolume().compareTo(o2.getVolume());
		}
		else {
			return o1.getPoid()-o2.getPoid();
		}
	}

}
