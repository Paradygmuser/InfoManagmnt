package anese.laghmich;

import java.time.LocalDate;
import java.util.Objects;

public class Reservation implements Comparable<Reservation>{
	private Personne personne ;
	private Cabine cabine;
	private LocalDate reservDate = LocalDate.now();
	
	public Reservation(Personne p, Cabine c) {
		personne = p;
		cabine = c;
	}

	public Personne getPersonne() {
		return personne;
	}

	public Cabine getCabine() {
		return cabine;
	}

	public LocalDate getReservDate() {
		return reservDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cabine, personne, reservDate);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(cabine, other.cabine) && Objects.equals(personne, other.personne)
				&& Objects.equals(reservDate, other.reservDate);
	}

	@Override
	public int compareTo(Reservation o) {
		if(this.personne.getNom().equals(o.getPersonne().getNom())) {
			if(this.personne.getPrenom().equals(o.getPersonne().getPrenom())) {
				return this.personne.getNumeroPassager()-o.getPersonne().getNumeroPassager();
			}
			else {
				return this.personne.getPrenom().compareTo(o.getPersonne().getPrenom());
			}
		}
		else {
			return this.personne.getNom().compareTo(o.getPersonne().getNom());
		}
	}
}
