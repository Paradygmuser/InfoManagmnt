package eu.eafcevere;

import java.util.Comparator;

public class NameComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getLastname().equals(o2.getLastname())) {
			return o1.getFirstname().compareTo(o2.getFirstname());
		}
		return o1.getLastname().compareTo(o2.getLastname());
	}

}
