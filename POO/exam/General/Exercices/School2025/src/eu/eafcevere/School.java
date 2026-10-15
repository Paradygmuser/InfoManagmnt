package eu.eafcevere;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class School {

	private String name;
	private Set<Student> students = new HashSet<>();
	//private List<Student> students = new ArrayList<>();
	private Set<Room> rooms = new HashSet<>();

	public void addStudent(Student s) {
		this.students.add(s);
	}
	public void addRoom(Room r) {
		this.rooms.add(r);
	}
	public void afficherParId() {
		TreeSet<Student> studentsTri = new TreeSet<>(students);
		for (Student student : studentsTri) {
			System.out.println(student);
		}
	}
	public void afficherParNom() {
		TreeSet<Student> studentsTri = new TreeSet<>(new NameComparator());
		studentsTri.addAll(students);
		for (Student student : studentsTri) {
			System.out.println(student);
		}
	}
	public void afficherRoomParId() {
		TreeSet<Room> roomsTri = new TreeSet<>(rooms);
		for (Room room : roomsTri) {
			System.out.println(room);
		}
	}
	public void afficherRoomParCapacity() {
		TreeSet<Room> roomsTri = new TreeSet<>(new CapacityComparator());
		roomsTri.addAll(rooms);
		for (Room room : roomsTri) {
			System.out.println(room);
		}
	}
	public School(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
