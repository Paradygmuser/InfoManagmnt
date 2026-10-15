package eu.eafcevere;

import java.util.Objects;

public class Room implements Comparable<Room>{

	private int id;
	private int capacity;
	
	public Room(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Room o) {
		return this.id-o.id;
	}

	@Override
	public String toString() {
		return "Room " + id + ", capacity=" + capacity + "";
	}
	
	
	
}
