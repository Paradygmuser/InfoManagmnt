package enael.eafc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RegistreNationalRand {
	/**
	 * cette classe est un composite de personne, chaque peronne a un numero national, ici je l'attribue aleatoirement
	 * dans la @donnerNumero vous trouverez un reversedString qui correspond au format habituel des registre nationnaux exemple quelqu'un est née en 1078 le 28 fevrier ca sera 760228
	 * mais il y a une maniere encor plus simple aevc SimpleDateFormater
	 */
	
	//je souhaiterais que quand je fais un new registre national, je renvoie direct un num national. dois je le mettre en static?
	private Random rand= new Random();
	
	public String donneNumero(String naissance) {
		//88882912-888-88
		String reversedString = "";
		String [] naissanceSplit  = naissance.split("/");
		for(int i = naissanceSplit.length-1; i>=0; i--) {
			if(naissanceSplit[i].length()==4) {
				reversedString+=naissanceSplit[i].charAt(2);
				reversedString+=naissanceSplit[i].charAt(3);
			}
			else {
				reversedString += naissanceSplit[i];				
			}
		}
		String rep = reversedString+"-"+rand.nextInt(100,1000)+"-"+rand.nextInt(10,100);
		return rep;
	}
	
	public String donnerNumerSDF(Date naissance) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		String retour = sdf.format(naissance);
		String rep = retour+"-"+rand.nextInt(100,1000)+"-"+rand.nextInt(10,100);
		return rep;
	}
}
