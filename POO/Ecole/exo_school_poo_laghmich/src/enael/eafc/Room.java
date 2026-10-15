package enael.eafc;

public class Room {
	//disons que l'enoncé  me permet d'imaginer le nombre de classe variable dans une ecole de 3 etage.
	//dison que lorsqu'on instancie une ecole on construit avec un nombre total de locaux que l'on divisera sur 4 etage rez de chaussez compris
	// de ce fait j'ai besoin d'un compteur pour savoir quel numeroattribuer je me lance sur une variable statique
	
	private static int compteurIdLocal = 0; //
	private int capaciteMax = 23; // pour l'instant on l'hardcode mais on pourra l'appler au constructeur
	private String id = "" ; //string pour qu'on persoanlise la premiere letre comme on veut voyons si le TreeSet classifiera.
	 // nbre de locaux max de l'etablissement(ref School)
	// ca serait cool de modifier ca quand on contruit l'ecole ainsi peut importe le nombre d'étage :)
	private int etage;
	private int numerolocal;
	//donc chaque etage aura se nombre de locaux setter par school, il faudra resoudre le probleme en math pour quantifier exactement le nbr de local ici c'est grossier
	// a chaque fois qu'on construit une piecce on va retirer le nombre de piece par etage.
	public Room ( int nbrEtage , int numerolocal) {
		this.etage=nbrEtage;
		this.numerolocal = numerolocal;
		setIdLocal(); // on peux appeler une methode dans un constructeur pour qu'il attribue direct un id
	}	
	public void setIdLocal() {
		if(numerolocal>=10) {
		    id = "C-"+etage+""+numerolocal; //concataine C de classe tiret etage
		   
		}
		else {
			id= "C-"+etage+"0"+numerolocal;
			
		}
	}	
	
	public int getCapaciteMax() {
		return capaciteMax;
	}
	
	
	

}
