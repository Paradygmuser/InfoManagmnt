
using System;
using System.Collections.Generic;

namespace BlackJAck2
{
	class Program
	{
		/*//Attributs de la table de jeux//*/
		private static Random rand = new Random();
		static List<string> couleurs= new List<string>();
		static string [,] cartes= new string[2,52]; // un seul deck de 52 cartes sans les jokers // 
		static List<string> listecartes= new List<string>();
		
		/*//Attributs du joueur//*/
		static List<string> cartesjoueurs = new List<string>();
		static List<string> cartescroupier = new List<string>();
		static int solde=200;
		static int betuser=0;
				
		public static void Main(string[] args)
		{
			while(solde!=0)
			{
				Jouer();
			}
			
			Console.ReadKey(true);
		}
		
		public static void RecommencerJouer()
		{
			    for(int i =0; i<cartescroupier.Count;i++)
			    {
			    	cartescroupier.RemoveAt(i);
			    }
			    
			    for(int i =0; i<cartesjoueurs.Count;i++)
			    {
			    	cartesjoueurs.RemoveAt(i);
			    }
			    
			    for(int i =0; i<listecartes.Count;i++)
			    {
			    	listecartes.RemoveAt(i);
			    }
		}
		
		public static void Jouer()
		{
			bool donner=false;
			bool arreter=false;
			int valeurjoueur=0;
			int valeurcroupier=0;
			
			RecommencerJouer();
			Deck();
			DemanderMiser();
			PremiereDistribConsole();
			
			valeurcroupier= ValeurCartes(cartescroupier);
			valeurjoueur = ValeurCartes(cartesjoueurs);
			
			arreter = OptionJouer(donner,arreter,valeurjoueur);			
			PrendreCarteCroupier(valeurcroupier);
			MontrerMainCroupier();
			
			valeurjoueur= ValeurCartes(cartesjoueurs);
			valeurcroupier=ValeurCartes(cartescroupier);
			
			if(arreter==true)
			{
				string fin = FinDePartie(valeurjoueur,valeurcroupier);
				Console.WriteLine(fin);
			}
			RecommencerJouer();
		}
		
		public static string FinDePartie(int qsd, int wxc)
		{
			
			Console.WriteLine("La partie est terminer");
			Console.WriteLine();
			string resultat = "";
			
			if(qsd>21)
			{
				resultat = "mise perdu, vous avez dépassé 21";
			}
			
			else if(qsd<wxc && wxc<=21)
			{
				resultat = "mise perdu, le croupier a la main la plus forte";
				
			}
			
			else if (qsd<wxc && wxc>21)
			{
				resultat = "Bien jouer vous avez gagnez : "+ (betuser*2)+" euros";
				solde=solde+(betuser*2);
			}
			
			else if (qsd>wxc && wxc<=21)
			{
				resultat = "Bien jouer vous avez gagnez : "+ (betuser*2)+" euros";
				solde=solde+(betuser*2);
			}
			
			else if(qsd==wxc && wxc<=21)
			{
				resultat = "Egalité, Mise rendu";
				solde+=betuser;
			}
			Console.WriteLine();
			return resultat;
		}
		
		public static void MontrerMainCroupier()
		{
			Console.WriteLine();
			Console.WriteLine("la main du croupier sont les cartes suivantes :");
			for (int i=0; i<cartescroupier.Count;i++)
			{
				Console.WriteLine(cartescroupier[i]);
			}
			Console.WriteLine("votre main sont les cartes suivantes :");
			for (int i=0; i<cartesjoueurs.Count;i++)
			{
				Console.WriteLine(cartesjoueurs[i]);
			}
		}
		
		public static void PrendreCarteCroupier(int abc)
		{
			if(abc<21)
			{
				do
				{
					DistribuerCartesCroupier(1);
					abc=ValeurCartes(cartescroupier);
					Console.WriteLine( "Le croupier recoit une nouvelle carte "+", voici sa main :");
					for(int i=0;i<cartescroupier.Count;i++)
					{
						if(i==1)
						{
							Console.WriteLine ( "** ****");
						}
						else
						{
							Console.WriteLine(cartescroupier[i]);
							
						}
					}
					Console.WriteLine();
					abc = ValeurCartes(cartescroupier);
				}
				while (abc<=21);
			}
			else
			{
				Console.WriteLine("le croupier s'arrete");
			}
			
		}
		
		public static bool OptionJouer(bool a, bool b, int valeur)
		{
			valeur=ValeurCartes(cartesjoueurs);
			while(b==false)
			{
				//les mise sont ouverte pour s'assoire etre le moment ou le premier joueur a la table recoit la premiere carte et s'arrete 10 econde apres que le croupierai recu ca deuxieme carte
				MenuJouer();
				int choix = VerifInt(Console.ReadLine());
				
				switch (choix)
				{
					case 1 :
						{
							if(b==false)
							{
							    DistribuerCartesJoueurs(1);
							    Console.WriteLine("nouvelle main : ");
							    for(int i =0;i<cartesjoueurs.Count;i++)
							    {
							    	Console.WriteLine(cartesjoueurs[i]);
							    }
							    valeur=ValeurCartes(cartesjoueurs);
							    if(valeur>=21)
							    {
							    	Console.WriteLine("Vous etes deja au dessusc de 21");
							    	Console.WriteLine();
							    	b=true;
							    	break;
							    }
							    Console.WriteLine();
							    a=true;							    
							    break;
							}
							break;
						}
					case 2 :
						{
							Console.WriteLine("Vous avez arretez, attendez la fin du tour pour miser");
							b=true;							
							break;
						}
				}
			}
			
			return b;
		}
	
		
		public static void DemanderMiser()
		{
			//le joueur peux sur encherir (pour plus tard)
			Console.WriteLine("Combien voulez vous miser ? seulement les billets de 5 euros sont acceptés(votre sole est de" + solde + " euros)");
			betuser = VerifInt(Console.ReadLine());
			if(betuser%5!=0)
			{
				Console.WriteLine("Ce n'est pas un montant accepté veuillez reproposez votre mise pour jouer");
				betuser=VerifInt(Console.ReadLine());
			}
			solde=solde-betuser;
		}
		
		public static int ValeurCartes(List <string> aa)
		{
			int hautecarte=10;
			int asvaleur1 =1;
			bool asvaleurFX=false;
			bool asPresent =false;
			int asvaleur11=11;
			int somme=0;
			string [] mains = new string[2];// je vais splitter sur le tiret de chaque string de la liste"valeur-couleur"
			
			foreach(string n in aa)
			{
				mains= n.Split('-');
				//dans ce petit talbeau seul le premiere indice et la valeur a garder pour la somme attention au symbole
				try
				{
					int e= Int32.Parse(mains[0]);
					somme +=e;
				}
				catch
				{
					if ( mains[0] =="A")
					{
						somme+=asvaleur1;
						asPresent=true;
					}
						
					
					else if(mains[0]=="J"| mains[0]=="Q" | mains[0]=="K")
					{
						somme+=hautecarte;
					}
					
					else if (somme <21 && asPresent ==true)
					{
						if (somme<=11 | somme==20 && asvaleurFX==false)
						{
							somme= somme-asvaleur1+asvaleur11;
							asvaleurFX=true;
							return somme;
						}
						else if(somme >=20 && asvaleurFX==true)
						{
							somme= somme-asvaleur11+asvaleur1;
						}
					}
				}
			}
			return somme;
		}
		
		public static string DistribuerCartesCroupier(int nbrcarte)
		{
			string cartesconcat2="";
			for(int i=0;i<nbrcarte;i++)// je sais qu'au blackJack on peux recevoir plus de deux cartes sur la tables je changerais le 2 apres me doumenter sur les regles, scéario ou on recoit seulement 2 cartes.
			{
			    string unecarte = DistribuerUneCarte();
			    cartescroupier.Add(unecarte);
			}
			cartesconcat2 = cartescroupier[0]+ " **** ";
			return cartesconcat2;
		}
		
		public static string DistribuerCartesJoueurs(int nbrcarte)
		{
			//la carte es retirer du pack apres distribtion
			string cartesconcat1="";
			for(int a=0;a<nbrcarte;a++)// je sais qu'au blackJack on peux recevoir plus de deux cartes sur la tables je changerais le 2 apres me doumenter sur les regles, scéario ou on recoit seulement 2 cartes.
			{
			    string unecarte = DistribuerUneCarte();
			    cartesjoueurs.Add(unecarte);
			    cartesconcat1 += unecarte+" ";
			}
			
			return cartesconcat1;
		}
		
		public static string DistribuerUneCarte()
		{
			int r = rand.Next(listecartes.Count-1); // la valeur du nombre de carte peux changer d'ou le cartes.Length/2 sinon j'ai vu sur internet le .GetLength methode non vu au cours car nous n'avons pas vu les tableau deux dismension
			string carteconcat = listecartes[r];
			listecartes.RemoveAt(r);
			return carteconcat;
			
		}
		
		public static void Deck()
		{
			ListerCouleurs();
			DistribuerCarreaux();
			DistribuerCoeurs();
			DistribuerPiques();
			DistribuerTrefles();
			for (int i=0;i<52;i++)
			{
				string cartconcat = cartes[0,i]+cartes[1,i];
				listecartes.Add(cartconcat);
			}
				
			
		}
		
		public static void DistribuerCarreaux()
		{
			for (int i=0;i<=12;i++)
			{
				if(i==0)
				{
					cartes[0,i]="A";
					cartes[1,i]=couleurs[0];
				}
				
				else if(i==10)
				{
					cartes[0,i]="J";
					cartes[1,i]=couleurs[0];
				}
				
				else if(i==11)
				{
					cartes[0,i]="Q";
					cartes[1,i]=couleurs[0];
				}
				
				else if(i==12)
				{
					cartes[0,i]="K";
					cartes[1,i]=couleurs[0];
				}
				
				else
				{
					cartes[0,i]=(i+1)+"";// je souhaite garder tout les indice du tableau y compris l'indice 0 comme données non vide je rajoute un a l'indice i pour que la donnée soit la valeur de la carte
					cartes[1,i]=couleurs[0];
				}
			}
			
		}
		
		public static void DistribuerCoeurs()
		{
			for(int i=13;i<=25;i++)
			{
				if(i==13)
				{
					cartes[0,i]="A";
					cartes[1,i]=couleurs[1];
				}
				
				else if(i==23)
				{
					cartes[0,i]="J";
					cartes[1,i]=couleurs[1];
				}
				
				else if(i==24)
				{
					cartes[0,i]="Q";
					cartes[1,i]=couleurs[1];
				}
				
				else if(i==25)
				{
					cartes[0,i]="K";
					cartes[1,i]=couleurs[1];
				}
				
				else
				{
					cartes[0,i]=((i+1)-13)+""; // la valeur de l'indice 14 sera 1(l'as) ainsi de suite pour tout les autre boucles
					cartes[1,i]=couleurs[1];
				}
			}
			
		}
		
		public static void DistribuerPiques()
		{
			for(int i=26;i<=38;i++)
			{
				if(i==26)
				{
					cartes[0,i]="A";
					cartes[1,i]=couleurs[2];
				}
				
				else if(i==36)
				{
					cartes[0,i]="J";
					cartes[1,i]=couleurs[2];
				}
				
				else if(i==37)
				{
					cartes[0,i]="Q";
					cartes[1,i]=couleurs[2];
				}
				
				else if(i==38)
				{
					cartes[0,i]="K";
					cartes[1,i]=couleurs[2];
				}
				
				else
				{
					cartes[0,i]=((i+1)-26)+"";
					cartes[1,i]=couleurs[2];
				}
			}
			
		}
		
		public static void DistribuerTrefles()
		{
			for(int i=39;i<=51;i++)
			{
				if(i==39)
				{
					cartes[0,i]="A";
					cartes[1,i]=couleurs[3];
				}
				
				else if(i==49)
				{
					cartes[0,i]="J";
					cartes[1,i]=couleurs[3];
				}
				
				else if(i==50)
				{
					cartes[0,i]="Q";
					cartes[1,i]=couleurs[3];
				}
				
				else if(i==51)
				{
					cartes[0,i]="K";
					cartes[1,i]=couleurs[3];
				}
				
				else
				{
					cartes[0,i]=((i+1)-39)+"";
					cartes[1,i]=couleurs[3];
				}
			}
			
		}
		
		public static void ListerCouleurs()
		{
			couleurs.Add("-Carreaux");
			couleurs.Add("-Coeur");
			couleurs.Add("-Pique");
			couleurs.Add("-Trèfle");
		}
		
		/*//Messages console//*/
		public static void DistributionConsole()
		{
			Console.WriteLine("Le joueur recoit une carte,");
			Console.WriteLine("Le croupier recoit une carte,");
			NouvelleCarteConsole();
		}
		
		public static void NouvelleCarteConsole()
		{			
			Console.WriteLine(" recoit une nouvelle carte");
		}
		
		public static void PremiereDistribConsole()
		{
			Console.WriteLine("Les Cartes du joueur : " + DistribuerCartesJoueurs(2));
			Console.WriteLine("Les cartes du Croupier :"+DistribuerCartesCroupier(2));
		}
		
		public static void MenuJouer()
		{
			Console.WriteLine("Que voulez vous faire?");
			Console.WriteLine("Tapez \"1\" pour demander une nouvelle carte");
			Console.WriteLine("Tapez \"2\" pour arreter et confronter le croupier");
		}
		
		//Verif int32parse
		public static int VerifInt(string xxr)
		{
			int choix=0;
			int mauvais = 0;
			try
			{
				choix= Int32.Parse(xxr);
			}
			catch
			{
				mauvais=1;
			}
			    while (mauvais ==1)
			    {
			    	Console.WriteLine("Veuillez Introduire un nombre svp");
			    	xxr=Console.ReadLine();
			    	if(Int32.Parse(xxr)>=0)
			    	{
			    		choix=Int32.Parse(xxr);
			    		mauvais=0;
			    	}
			    }
			
			return choix;
		}
		
	}
}