package enael.eafc;

import java.util.Objects;

public class Examen implements Comparable<Examen> {
	String titre ;
	String description ;
	int id;
	int point;	
	public Examen(Exam e) {
		this.titre=e.getTitre();
		this.description=e.getDescription();
		this.id=e.getId();
	}	
	public String getTitre() {
		return titre;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return  titre + ", point=" + point + "--";
	}
	@Override
	public int compareTo(Examen o) {
		// TODO Auto-generated method stub
		return id-o.id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, id, point, titre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Examen other = (Examen) obj;
		return Objects.equals(description, other.description) && id == other.id && point == other.point
				&& Objects.equals(titre, other.titre);
	}
	

}
