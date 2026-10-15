package anese.laghmich;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Objects;

public class Personne  implements Comparable<Personne>{
	private String nom, prenom;
	private int numeroPassager;
	private LocalDate datenaissance;
	
	public Personne(String nom, String prenom, int numeroPassager, String datenaissance) {
		this.nom=nom;
		this.prenom=prenom;
		this.numeroPassager=numeroPassager;
		convertiDate(datenaissance);
	}

	private void convertiDate(String datenaissance2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		try {
			Instant i = sdf.parse(datenaissance2).toInstant();
			ZoneId zid = ZoneId.systemDefault();
			datenaissance=LocalDate.ofInstant(i, zid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int donnerSonAge() {
		Period p = Period.between(datenaissance, LocalDate.now());
		return p.getYears();
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getNumeroPassager() {
		return numeroPassager;
	}

	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroPassager);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Personne other = (Personne) obj;
		return numeroPassager == other.numeroPassager;
	}

	@Override
	public int compareTo(Personne o) {
		if(this.nom.equals(o.getNom())) {
			if(this.prenom.equals(o.getPrenom())) {
				return this.numeroPassager-o.getNumeroPassager();
			}
			else {
				return this.prenom.compareTo(o.getPrenom());
			}
		}
		else {
			return this.nom.compareTo(o.getNom());
		}
	}

}
