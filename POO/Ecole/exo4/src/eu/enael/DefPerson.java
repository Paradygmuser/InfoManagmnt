package eu.enael;


import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public abstract class DefPerson {
	
	protected int matriculation;
	protected String nom;
	protected int anneeDeNaissance ;
	protected int age ;
	protected static int anneDAjourdhuit = 2025; // comme ca la date aura tj la meme espace memoir peut importe l'instan de DefPerson
	
	
	public DefPerson() {
	
	}
	
	public String monAge() {
		/*Instant ajduit = Instant.now(year); // comment on prend la date du jour comme en sql?*/
		
		int age = anneDAjourdhuit - anneeDeNaissance;
		this.age=age;
		return "cette année 2025 j'ai " + age;
	}
	
	public void jeSuis() {
		System.out.println(this.nom + (this.matriculation));
		pensionne();
	}
	
	public void pensionne() {
		if (this.age>=67) {
			System.out.println("j'ai été un bon esclave, je suis pensionnée mnt...");		
		}
		else {
			int restant = 67 - this.age ;
			System.out.println("il me reste encore : " + restant + "années a tiré avant la pension");
		}		
	}

}
