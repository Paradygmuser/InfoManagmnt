package enael.eafc;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.nio.*;

public class GestionnaireAvion {
	private TreeSet<Transportable> stock = new TreeSet<Transportable>();
	private Map<AvionTransport, TreeSet<Transportable>> gestionAvion = new TreeMap<AvionTransport, TreeSet<Transportable>>(); // je fais ca pour pas donner de nom d'instance à un avion qui est la clef de map associé a son TreeSet
	private Scanner scann = new Scanner (System.in);
	
	public GestionnaireAvion (int nombreTransportableEnRayonOut) {
		Entrepot entrepot = new Entrepot (nombreTransportableEnRayonOut);
		this.stock = entrepot.getStock();
		chargerToutLeStock();
	}
	
	public void ajouterTransportable(Transportable t, AvionTransport v, TreeSet<Transportable> contenuAvion) {
			contenuAvion.add(t);
			v.setPoidActuel(v.getPoidActuel()+t.getPoid());
			v.setPlacePrise(v.getPlacePrise()+t.getPlace());	
	}	
	public void remplirAvion (AvionTransport v) {
		TreeSet<Transportable> contenuAvion = new TreeSet<Transportable>();
		TreeSet<Transportable> stockCopy = new TreeSet<Transportable>();
		stockCopy.addAll(stock);
		//pour eviter l'erreur de modification de la collection pendant l'iteration
		String nomFichier = "/Users/emac/ExoTransport/surchargement_" + v.getMatricule() + ".log"; //pour avoir un fichier par instance d'avion j'ai utilisé le lien absolu pour mac et windows j'espre
		File path = new File(nomFichier);
		File parentDir = path.getParentFile();
		if (!parentDir.exists()) {
		    parentDir.mkdirs(); // crée tous les dossiers nécessaires
		}
		try {
			path.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // puis crée le fichier
		boolean avionPlein = false;
		//on ouvre le buffer une fois
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) { 
		    while(avionPlein==false) {
		    	boolean transpotableAjouter = false;//pour savoir si on a reussi a ajouter un transportable
			    for(Transportable t : stockCopy) {
				    if(v.getPoidActuel()+t.getPoid()<=v.getPoidMax()&& v.getPlacePrise()+t.getPlace()<=v.getNbPlace()) {
				        ajouterTransportable(t, v, contenuAvion);
				        stockCopy.remove(t);
				        transpotableAjouter = true;
				        System.out.println("Transportable "+ t.getPlaqueMatriculation()+" ajouté à l'avion "+ v.getMatricule());
				        break;
				    }
			    }
			    if(!transpotableAjouter) {
			    	Transportable t = stockCopy.first();
			    	//si je peut pas ajouter le transportable je l'ecris dans le fichier log il est le premier de la liste 
					if(t.getPoid()+v.getPoidActuel()>v.getPoidMax()) {
	    				bw.write("L'avion "+ v.getMatricule() + " ne peut pas prendre le transportable "+ t.getPlaqueMatriculation()+" car il depasse le poid maximal.\n");		
		    		}
			    	else {
				    	bw.write("L'avion "+ v.getMatricule() + " ne peut pas prendre le transportable "+ t.getPlaqueMatriculation()+" car il depasse le nombre de places maximal.\n");
			    	}
			        avionPlein = true;
			    }
			}		
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 //aussi si je peux rajouter un autre transportable si il ya encor de la place et du poid
		if(v.getPoidActuel()<v.getPoidMax() && v.getPlacePrise()<v.getNbPlace()) {
			//cherche une palette a rajouter si possible
			Transportable tetris = null ;
			for(Transportable tr : stockCopy) {
				if(v.getPoidActuel()+tr.getPoid()<=v.getPoidMax()&& v.getPlacePrise()+tr.getPlace()<=v.getNbPlace()) {
					tetris = tr;
					break;
				}
			}
			if(tetris!=null) {
				ajouterTransportable(tetris, v, contenuAvion);
				stockCopy.remove(tetris);
			}			
		}
		stock.clear();
		stock.addAll(stockCopy); //on remplace le stock par le modifié
		//une fois l'avion plein je l'ajoute a la map avec son contenu
		gestionAvion.put(v, contenuAvion);	
	}
	public void chargerToutLeStock() {
		
		while(stock.size()>0) {
			remplirAvion(new AvionTransport());
		}
	}	
	public void afficherAvionsPret() {
		int i= 1;
		for (AvionTransport v : gestionAvion.keySet()) {
			System.out.println(i+"-"+v.getMatricule()+v.getEtatAvion());
		}
	}	
	public void afficherAvionEtContenant() {
		System.out.println("quel avion voulais cous consultez?");
		afficherAvionsPret();
		int choix = scann.nextInt();		
		AvionTransport avionChoisi = null;
		int i=1;
		for (AvionTransport v : gestionAvion.keySet()) {
			if(i==choix) {
				avionChoisi = v;
				break;
			}
			i++;
		}		
		System.out.println(avionChoisi.toString());		
	}
}
