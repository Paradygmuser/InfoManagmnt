package be.eafc.marwan;

public class MaxWeightReachedException extends Exception {

	private Chargeable materiel;
	
	public MaxWeightReachedException(String message, Chargeable materiel) {
		super(message);
		this.materiel = materiel;
	}
}
