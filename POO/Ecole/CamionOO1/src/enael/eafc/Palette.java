package enael.eafc;

public class Palette extends ChargeableMaterial{
	//je pars du postulat que toutes les palettes ont le meme poid et le meme volume.
	private int poidPalette=150;
	private float volumePalette=1.20f;
	
	public Palette(String identifiant) {
		this.identifiant=identifiant;
		this.poid=poidPalette;
		this.volume=volumePalette;
	}	
}
