package enael.eafc;

public class ChambreFullException extends Exception {
	
	public ChambreFullException() {
		super();
		
	}
	public String raisonThrow() {
		return "Le nombre maximal de Personne est atteint";
	}

}
