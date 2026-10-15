package enael.eafc;

public class Affichage {
	public void afficher(String s) {
		int l = s.length();
		for(int i=0;i<l*6;i++) {
			System.out.print("#");
		}
		System.out.println();
		for(int i=0;i<l*6;i++) {
			System.out.print("#");
		}
		System.out.println();
		System.out.print("#");
		for(int i=0;i<l*5;i++) {
			//ayant recuperer la longeur de la phrase je vais jouer avec les *4 ou 3 pour l'instant ils sont arbitraire mais je pense 5 et 2. ou 3 et 2
			if(i==(l*5/2)-2) {
				System.out.print(s);
			}
			else {
				System.out.print(" ");
			}			
		}
		System.out.println("#");		
		for(int i=0;i<l*6;i++) {
			System.out.print("#");
		}
		System.out.println();
		for(int i=0;i<l*6;i++) {
			System.out.print("#");
		}
		System.out.println();
	}
	//donc 3 block de meme taill, pour la premiere ligne et 2 block arriver a la moitier du block on rajoute le string qui a la meme taille que le bloc.

}
