package enael.eafc;

public class MainOutCamion {

	public static void main(String[] args) {
		//normalmnt builder pattern. mais bon...
		Camion camion1 = new Camion(1450, 20f,"CAM-001");
		
		ChargeableMaterial palette1 = new Palette("PAL-001");
		ChargeableMaterial palette2 = new Palette("PAL-002");
		ChargeableMaterial palette3 = new Palette("PAL-003");
		ChargeableMaterial palette4 = new Palette("PAL-004");
		ChargeableMaterial vrac1 = new Vrac("VRC-001");
		ChargeableMaterial vrac2 = new Vrac("VRC-002");
		ChargeableMaterial vrac3 = new Vrac("VRC-003");
		ChargeableMaterial vrac4 = new Vrac("VRC-004");
		ChargeableMaterial vrac5 = new Vrac("VRC-005");
		ChargeableMaterial vrac6 = new Vrac("VRC-005");
		ChargeableMaterial vrac7 = new Vrac("VRC-007");
		ChargeableMaterial vrac8 = new Vrac("VRC-008");
		
		LoadMasterTone lmt = LoadMasterTone.getInstance();
		
		try {
			lmt.ajouterMaterielCamion(camion1, palette1, palette2, vrac1, vrac4, vrac6, palette3, palette4);
		} catch (MaxWeightReachedException e) {
			System.out.println(e.getMessage());
		} catch (MaxVolumeReachedException e) {
			System.out.println(e.getMessage());
		}
		
		lmt.donnerPoidCharger(camion1);
		System.out.println("/////////////////////////");
		lmt.donnerVolumeCharger(camion1);
		System.out.println("/////////////////////////");
		lmt.afficherListeParId(camion1);
		System.out.println("/////////////////////////");
		lmt.afficherListeParPoid(camion1);
		System.out.println("/////////////////////////");
		lmt.afficherListeParVolume(camion1);
		System.out.println("/////////////////////////");

	}

}
