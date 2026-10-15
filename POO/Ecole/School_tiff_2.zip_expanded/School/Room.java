package School;

public class Room {
	
	private int Numloc;
	private int capacity;
	
	  public Room(int NumLoc, int capacity) {
	        this.Numloc = NumLoc;
	        this.capacity = capacity;
	    }
		
	
	public int getNumloc() {
		return Numloc;
	}
	public void setNumloc(int numloc) {
		Numloc = numloc;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Room [Numloc=" + Numloc + ", capacity=" + capacity + "]";
	}
	
	
	

}
