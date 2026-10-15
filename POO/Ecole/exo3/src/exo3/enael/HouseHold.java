package exo3.enael;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HouseHold {
	
	private int id ; 
	private int revenuAnuel ;
	private int nmbrePersonne;
	
	private TreeMap<Integer, Integer> donneeO  = new TreeMap<Integer, Integer>(); // treemap pour qu'il soit ajouter dans l'ordre avec l'id qui est un attribut a part.
	
	public void insertdata( int a, int b) {	
		donneeO.put(a,b);//pour y mettre les valeur de menage autre que l'identifiant		
		}
	
	public HouseHold(int id, int a, int b) {
		
		this.id=id;
		this.revenuAnuel=a;
		this.nmbrePersonne=b;		
	}	
	
	public TreeMap<Integer, Integer> getDonnees() {
		donneeO.clear(); // j'efface le tableau pour qu'il ne garde pas tout les donnee en memoir pour le vrai tableau final de la region.
		insertdata(this.revenuAnuel,this.nmbrePersonne);
		return this.donneeO;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public Integer getRevenu() {
		return this.revenuAnuel;
	}
	public Integer getNbrPrsn() {
		return this.nmbrePersonne;
	}
	
}
