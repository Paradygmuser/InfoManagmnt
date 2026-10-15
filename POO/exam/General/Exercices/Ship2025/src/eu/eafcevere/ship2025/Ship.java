package eu.eafcevere.ship2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Ship {

	private int maxCapacity = 100;
	private int maxWeight = 95000;
	private Set<Vehicle> vehicles = new TreeSet<>();
	
	public boolean addVehicle(Vehicle v) {
		if((getTakenPlaces()+v.getPlaces()>maxCapacity) || getTakenWeight()+v.getWeight()>maxWeight) {
			return false;
		}else {
			vehicles.add(v);
			return true;
		}
	}
	public int totalWeight() {
		return getTakenPlaces();
	}
	public void removeVehicle() {
		vehicles.remove(vehicles.size()-1);
	}
	public int getTakenPlaces() {
		int places = 0;
		for (Vehicle vehicle : vehicles) {
			places+=vehicle.getPlaces();
		}
		return places;
	}
	public int getTakenWeight() {
		int weight = 0;
		for (Vehicle vehicle : vehicles) {
			weight+=vehicle.getWeight();
		}
		return weight;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}
	public String getContent() {
		return getTakenWeight()+" kg and " + getTakenPlaces()+"places";
	}
	public String afficherVehicules() {
		String result = "";
		for (Vehicle vehicle : vehicles) {
			result+=vehicle.chassis+" "+vehicle.marque+" "+vehicle.color+"\n";
		}
		return result;
	}
	public String afficherVehiculesParChassis() {
		Set<Vehicle> localSet = new TreeSet<>(new ChassisComparator());
		localSet.addAll(vehicles);
		
		String result = "";
		for (Vehicle vehicle : localSet) {
			result+=vehicle.chassis+" "+vehicle.marque+" "+vehicle.color+"\n";
		}
		return result;
	}
	public String afficherVehiculesParColor() {
		Set<Vehicle> localSet = new TreeSet<>(new ColorComparator());
		localSet.addAll(vehicles);
		
		String result = "";
		for (Vehicle vehicle : localSet) {
			result+=vehicle.chassis+" "+vehicle.marque+" "+vehicle.color+"\n";
		}
		return result;
	}
	public String afficherVehiculesParKM() {
		Set<Vehicle> localSet = new TreeSet<>(new KMComparator());
		localSet.addAll(vehicles);
		
		String result = "";
		for (Vehicle vehicle : localSet) {
			result+=vehicle.chassis+" "+vehicle.marque+" "+vehicle.color+" "+vehicle.km+"\n";
		}
		return result;
	}
}
