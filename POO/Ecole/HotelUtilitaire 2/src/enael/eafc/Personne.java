package enael.eafc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Personne implements Comparable<Personne>{
	private String numeroNational;
	private String nom;
	private String prenom;
	private Date naissance;
	private String naissanceString; // pour le toString
	private RegistreNationalRand numero =new RegistreNationalRand(); //cette classe ne pocede qu'une methode, mais un private Rand.
	
	//je vais donc coder en dure les constructeur de chaque objet, il me faut un date formater pour convertir le strig dans le constructeur
	public Personne(String nom, String prenom, String naissance) {
		//numeroNational=numero.donneNumero(naissance);
		
		this.nom=nom;
		this.prenom=prenom;
		convertirStringDate(naissance);
		naissanceString=naissance;
		
		numeroNational=numero.donnerNumerSDF(this.naissance);
	}
	
	private void convertirStringDate(String naissanceF) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		//Date reponse = new Date() ;
		try {
			naissance= sdf.parse(naissanceF);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return reponse;
		
	}
	
	public int donnerSonAge() {
		Instant i = naissance.toInstant();
		ZoneId zid = ZoneId.systemDefault();
		Period p = Period.between(LocalDate.ofInstant(i, zid), LocalDate.now());
		return p.getYears();
		
		/**
		 * si on fait juste naissance en LocalDate au lieu de Date ca devient juste
		 * return Perido.between(naissance, LocalDate.now()).getYears();
		 */
	}

	@Override
	public int compareTo(Personne o) {
		if(this.nom.equals(o.nom)) {
			return this.prenom.compareTo(o.prenom);
		}
		else {
			return this.nom.compareTo(o.nom);
		}
	} // me permettra normalmnt a chaque to string de retourner par orde de nom de famille puis prenom

	public String getNumeroNational() {
		return numeroNational;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public Date getNaissance() {
		return naissance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(naissance, nom, numeroNational, prenom);
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
		return Objects.equals(naissance, other.naissance) && Objects.equals(nom, other.nom)
				&& Objects.equals(numeroNational, other.numeroNational) && Objects.equals(prenom, other.prenom);
	}

	@Override
	public String toString() {
		return "numeroNational : " + numeroNational 
				+ " , nom : " + nom 
				+ " , prenom : " + prenom 
				+ ", naissance="	+ naissanceString;
	}
}
