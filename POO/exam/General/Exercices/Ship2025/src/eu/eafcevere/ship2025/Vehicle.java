package eu.eafcevere.ship2025;

import java.util.Objects;

public abstract class Vehicle implements Comparable<Vehicle>{

	protected String marque;
	protected String color;
	protected String chassis;
	protected int km;
	
	public Vehicle(String chassis, String marque, String color, int km) {
		this.chassis = chassis;
		this.marque = marque;
		this.color = color;
		this.km = km;
	}
	public abstract int getPlaces();

	public abstract int getWeight();
	@Override
	public int hashCode() {
		return Objects.hash(chassis);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		return Objects.equals(chassis, other.chassis);
	}
	
	
}
