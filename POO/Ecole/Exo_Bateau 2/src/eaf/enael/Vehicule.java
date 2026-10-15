package eaf.enael;

import java.util.ArrayList;

public abstract class Vehicule {

	protected int poid;
	protected int place;
	// les sous classe herite (transfert de comportement et etat) des méthodes suivantes : 
	
	public abstract String jeSuis() ; // pour le getContent e Ship
	public int getPoid() {
		return this.poid;
	}
	
	public int getPlace() {
		return this.place;
	}
	

}
