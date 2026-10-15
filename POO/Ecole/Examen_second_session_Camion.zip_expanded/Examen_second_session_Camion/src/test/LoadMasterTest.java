package test;

import static org.junit.jupiter.api.Assertions.*;
import src.*;

import org.junit.jupiter.api.Test;

class LoadMasterTest {

	@Test
	void test() {
		LoadMaster lm = LoadMaster.getInstance();
		Materiel pallete = new Palette("azdsasd", 200, 1.2);
		Materiel vrac = new Vrac("sqfdsdf",235,1.7);
		
		Camion camion1 = new Camion(1000, 50);
		
		try {
			lm.chargerUnMateriel(camion1, vrac);
			lm.chargerUnMateriel(camion1, pallete);
		} catch (MaxVolumeReachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MaxWeightReachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int poidAttend = pallete.getPoids()+vrac.getPoids();
		/**
		 * poidAttend correspond au volume des deux mateirel qui est la valeur qu'on attend, et le poid pris du camion réagit bien a ce nouveaux materiel ajouter.
		 */
		assertEquals(poidAttend, camion1.getPoidPris());	
	}

}
