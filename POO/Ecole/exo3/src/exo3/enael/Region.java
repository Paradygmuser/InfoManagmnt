package exo3.enael;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Region {
	private HashMap<Integer,TreeMap<Integer,Integer>> tableMenageV = new HashMap<Integer, TreeMap<Integer, Integer>>();
	private ArrayList<HouseHold> listeDesMenage = new ArrayList<HouseHold>();
	
	public void listerMenage() {
		
		//il faudrait utiliser un ReadLine pour encoder les donnee.
		listeDesMenage.add(new HouseHold(1041,12180,4));
		listeDesMenage.add(new HouseHold(1062,13240,3));
		listeDesMenage.add(new HouseHold(1327,19800,2));
		listeDesMenage.add(new HouseHold(1483,22458,8));
		listeDesMenage.add(new HouseHold(1900,17000,2));
		listeDesMenage.add(new HouseHold(2112,18125,7));
		listeDesMenage.add(new HouseHold(2345,15623,2));
		listeDesMenage.add(new HouseHold(3210,3200,6));
		listeDesMenage.add(new HouseHold(3600,6500,5));
		listeDesMenage.add(new HouseHold(3601,11970,2));
		listeDesMenage.add(new HouseHold(4725,8900,3));
		listeDesMenage.add(new HouseHold(6217,10000,2));
		listeDesMenage.add(new HouseHold(9280,6200,1));		
	}	
	
	public void inserData() {
		listerMenage();
		for (HouseHold i : listeDesMenage) {
			tableMenageV.put(i.getId(), new TreeMap<>( i.getDonnees())); // je prend les donnee de la liste vers la map de donnée qui nous sera utile .
		}		
	}
	
	public Region() {
		inserData();
	}
	
	public void retourDonne() {
		System.out.println("il y a "+ listeDesMenage.size()+ " mènages enrerigstré dans la region");
		System.out.println("id->{revenuAnnuel=nbr_personnes");
		for(HouseHold i : listeDesMenage) {
			System.out.println( i.getId() +"->"+i.getDonnees());			
		}
	}
	
	public void moyenneRevenuEtExcesList() {
		int sommesDesRevenu =0 ;
		for (HouseHold i : listeDesMenage) {
			sommesDesRevenu += i.getRevenu();			
		}
		double moyenne = sommesDesRevenu/listeDesMenage.size();
		System.out.println("la revenu moyen par ménage est de :" + moyenne +"$ Canadiens");
		
		for (HouseHold i : listeDesMenage) {
			if(i.getRevenu()>moyenne) {
				System.out.println(i.getId()+"->"+i.getRevenu());
			}
		}
	}
	
	public void pourcentagePauvrete() {
		double pourcentageP ;
		int m ; // nbr de personne que compose le menage
		int p ; // correspondant au seuil de pauvreter correspondant au nbr de personne composant le menage.
		int menageSousleSeuil = 0;
		for(HouseHold i : listeDesMenage) {
			m = i.getNbrPrsn();
			p = 6500 + 750 * (m - 2);
			//si le revenu est sous le seuil de pauvreter calculer alors le compté
			if(i.getRevenu()<p) {
				menageSousleSeuil ++;
			}
		}		
		pourcentageP = 100* menageSousleSeuil/listeDesMenage.size();		
		System.out.println("Dans la region la pauvreté à atteint "+ pourcentageP + "% des menages" );
	}
	
	
}
