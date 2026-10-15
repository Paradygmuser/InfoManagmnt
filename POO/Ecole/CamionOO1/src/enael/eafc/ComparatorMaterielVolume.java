package enael.eafc;

import java.util.Comparator;

public class ComparatorMaterielVolume implements Comparator<ChargeableMaterial> {

	@Override
	public int compare(ChargeableMaterial o1, ChargeableMaterial o2) {
		if(o1.getVolume()==o2.getVolume()) {
			return o1.getIdentifiant().compareTo(o2.getIdentifiant());
		}
		else {
			return String.format("%.2f",o1.getVolume()).compareTo(String.format("%.2f", o2.getVolume()));
		}
	}

}
