using System;
using System.Collections.Generic;

namespace CardGame3
{
	public class CardGame
	{
		/*Attributs*/
		Random amadouAeatoire = new Random();
		string [] colors = {"Carreaux","Coeur","Pique","Trefle"};
		string [] valeurs = new string[13];//tablea pour le creation du paquet carte ordonnée comme dans l'ennoncé de bataille.
		List<string> paquetdecarte = new List<string>();
		List<string> paquetDeCarteMelanger= new List<string> ();//paquet de carte melanger declarer non assigner et le sera lors de la SimulationPartie()
		List<string> mainjouer = new List<string>();
		List<string> mainbanquier = new List<string>(); //liste reprenant les carte recu
		int valeurjoueur ;
		int valeurbanquier ; //attribut a ecraser a chaque distribution pour la valeur, une methode void s'en occupe.
			
		/*Methodes*/
		public void AjouterNombre()
		{
			for(int i =0; i<9; i++)
			{
				valeurs[i]=(i+2)+"";
			}
			valeurs[9]="vallet";
			valeurs[10]="Dame";
			valeurs[11]="Roi";
			valeurs[12]="As";			
		}
		
		public void CreerJeuxDeCarte()
		{
			for(int y=0 ; y<colors.Length;y++) // y=3
			{
				for(int i =0; i<valeurs.Length;i++)
				{
					//dans le cas ou le format demander est Reine-10-Carreaux
					if(i<9)
					{
						paquetdecarte.Add(valeurs[i]+"-"+valeurs[i]+"-"+colors[y]);
					}
					else if(i==12)
					{
						paquetdecarte.Add(valeurs[i]+"-"+"11"+"-"+colors[y]);
					}
					else 
					{
						paquetdecarte.Add(valeurs[i]+"-"+"10"+"-"+colors[y]);
					}
				}
			}
		}
		
		/*public void AfficherCartes()
		{
			AjouterNombre();
			CreerJeuxDeCarte();
			foreach(string n in paquetdecarte)
			{
				Console.WriteLine(n);
			}
		}*/
		
		public List<string> Melanger()
		{
			AjouterNombre();
			CreerJeuxDeCarte();// pour retourner un paquet de carte melanger je souhaiterais utiliser les tableau avant.
			List<string> paquet= new List<string>();
			while(paquetdecarte.Count>0)
			{
				int postionListe = amadouAeatoire.Next(paquetdecarte.Count);				
				paquet.Add(paquetdecarte[postionListe]);
				paquetdecarte.RemoveAt(postionListe);
			}
			return paquet;
		}
		
		public int GetValeur(string parametre)
		{
			string [] valeursplit = parametre.Split('-');
			int valeurcarte = Int32.Parse(valeursplit[1]);
			return valeurcarte;
		}
		
		public void DistrbuerCarte(int nbredecarte, List<string> joueurOUcroupier)
		{
			for(int i=0; i<nbredecarte;i++)
			{
				joueurOUcroupier.Add(paquetDeCarteMelanger[0]);
				paquetDeCarteMelanger.RemoveAt(0);
			}
		}
		
		public void ComparerValeur(List<string> mainjoueur , List<string> mainbanquier) //la comparaison ecrasera les attribut de valeur de mains de chaque joueurs.
		{
			valeurjoueur=0;
			valeurbanquier=0; // pour ré initialisé les valeur et qu'il ne gard pas les precedente du a a l'apl de cette methode.u
			foreach(string n  in mainjouer)
			{
				valeurjoueur +=GetValeur(n);
			}
			foreach(string a in mainbanquier)
			{
				valeurbanquier +=GetValeur(a);
			}			
		}
		
		public bool ProposerChoix()//petit menu conole returnant un bool utiliser dans le main Menu()
		{
			Console.WriteLine("que voulez vous faire? \"oui\"-pour demander une carte ou \"non\" pour confrontier le banquier");
			string choix = Console.ReadLine();
			bool choixbool=false;
			if (choix == "oui")
			{
				choixbool=false;
			}
			else
			{
				choixbool = true;
			}
			return choixbool;
		}
		
		public void AfficherCartejoueur() 
		{
			Console.WriteLine("la main du joueur1 : ");
			for(int i=0;i<mainjouer.Count;i++)
			{
				Console.WriteLine(mainjouer[i]);
			}
			Console.WriteLine("valeur joueur 1 : "+valeurjoueur);
		}
		
		public void AfficherCarteBanquier()
		{
			Console.WriteLine("banquier pocede les carte : ");
			for(int i=0;i<mainbanquier.Count;i++)
			{
				Console.WriteLine(mainbanquier[i]);
			}
			Console.WriteLine("valeur banquier : "+valeurbanquier);
		}
		
		public void Menu() // la fonctionnalité est de rajouter une carte si le joueur choisi de s'en rajouter une
		{
			bool boolchoix =false;
			while(boolchoix==false && valeurjoueur<21) //tant que bool choix est faux (car dans la methode proposer choix le joueur demande une carte et le choix est false. si il demande confronter la banque le bool devent vrai. ET si sa somme est en dessou de 21 il peut demander le menu ProposerCarte
			{
				boolchoix = ProposerChoix();
				if(boolchoix==true)
				{
					break;
				}
				else
				{
				    DistrbuerCarte(1,mainjouer);				
				    ComparerValeur(mainjouer,mainbanquier);
				    AfficherCartejoueur();
				}
			}
		}
		
		public void ReinitialiserPartie()
		{
			paquetDeCarteMelanger.Clear();
			mainbanquier.Clear();
			mainjouer.Clear(); //clear efface la liste, ici chaque main est effacer et chaque paquet melanger l'est.
		}
		
		public void DebutDepartie()
		{
			DistrbuerCarte(2,mainjouer);
			DistrbuerCarte(2,mainbanquier);
			ComparerValeur(mainjouer,mainbanquier);
			AfficherCartejoueur();
		}
		
		public void FinDePartie()
		{
			if(valeurjoueur>valeurbanquier && valeurjoueur<=21)
			{
				Console.WriteLine("bravos vous avez gagnez");
				AfficherCarteBanquier();
				AfficherCartejoueur();
			}
			else if(valeurjoueur<=21 && valeurbanquier>21)
			{
				Console.WriteLine("bravos vous avez gagnez");
				AfficherCarteBanquier();
				AfficherCartejoueur();
			}
			else
			{
				Console.WriteLine("vous avez perdu");
				AfficherCarteBanquier();
				AfficherCartejoueur();
			}
		}
		
		public void SimulerPartie()
		{
			bool findepartie = false; //bool pour terminer le jeux
			int numerodemanche =0; //imaginons que c'est soit qu'on doit ecrir dans le streamwriter
			
			
			while(findepartie==false)
			{
				numerodemanche++;
				ReinitialiserPartie(); // a cahque tour la banque remélange le paquet de carte efface les mians des joueurs.
				paquetDeCarteMelanger = Melanger(); //je refait une liste paquetdecarte melanger avec la methode melanger.
				DebutDepartie();
				Menu();
				ComparerValeur(mainjouer,mainbanquier);
				
				Console.WriteLine("ok nous allons proceder la confrontation"); //apres le break du menu() on lance unn message console pour deplanter le break.
				while(valeurbanquier<valeurjoueur && valeurbanquier<21 && valeurjoueur<=21)
				{
					DistrbuerCarte(1,mainbanquier);
					ComparerValeur(mainjouer,mainbanquier);
				}
				
				FinDePartie();
				Console.WriteLine("voulez-vous rejouer?");
				string finchoix= Console.ReadLine();
				if(finchoix =="non")
				{
					findepartie=true;
				}
			}
			Console.WriteLine("au revoir");
		}
	}
}
