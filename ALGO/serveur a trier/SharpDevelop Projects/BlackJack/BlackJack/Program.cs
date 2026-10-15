using System;
using System.Collections.Generic;

namespace BlackJack
{

	class Program
	{
		
		static bool confirmation ;
		public static void Main(string[] args)
		{
			
			confirmation = Joueur.Miser();
			if(confirmation)
			{
				
			string resultat = Joueur.JouerLaPartie(confirmation);
				Console.WriteLine(resultat);
			}
			else
			{
				Joueur.Miser();
			}

			Console.ReadKey(true);
		}
	}
	class Deck
	{
		private  int [,] jeuxdecartes = new int[2,52];
		public  int[,] JeuxDeCarte()
		{
			for(int i=0; i<=12;i++)// le jeux des carreaux qui aura la valleur 30
			{
				jeuxdecartes[0,i] = i+1;
				jeuxdecartes[1,i]= 30;
			}
			
			for(int a=13; a<=25;a++)// le jeux des coeur qui aura la valleur 40
			{
				jeuxdecartes[0,a] = a-12;// car je veux que les carte est des nombre de 1 a 13 mais si je fais pas ca mon tableau ne se rempli pas jusqu'au bout
				jeuxdecartes[1,a]= 40;
			}
			
			for(int c=26; c<=38; c++)// le jeux des pique qui aura la valleur 50
			{
				jeuxdecartes [0,c] = c-25;
				jeuxdecartes [1,c]= 50;
			}
			
			for(int y=39; y<=51;y++)// le jeux des trefle qui aura la valleur 60
			{
				jeuxdecartes [0,y] = y-38;
				jeuxdecartes [1,y]= 60;
			}
			return jeuxdecartes;
		}
		
	}
	
	class Joueur
	{ 	
		static Random rand= new Random();
		static Deck newDeck= new Deck();
		public static int [,] deckarray = newDeck.JeuxDeCarte();// le retour de l'array fabriqué plus haut
		static int[,] intmain= new int[2,2];// tableau uniquemnt pour une main
		
		//int id=0; // je donnerais l'id=0 au croupier j'ai remarqué qu'avec les erreur afficher à la console je pouvais appelé cette attribut BlackJack.Joueur.id il me sera peut etre utile plus tard
		static  List<string> lamain= new List<string>();// besoin pour les regle de carte doublé ou de split du blackjack
		static int carte1;
		static int carte2;// j'aurais besoin des nombre aleatoire plus tard
		static int score;
		
		public static bool Miser ()
		{
			bool vf=false;
			Console.WriteLine("Confirmer la mise de 10$? Appuyer sur le bouton 0 pour confirmer si non n, appuyer bien sur la touche de votre choix");
			string confrimestring=Console.ReadLine();
			if(confrimestring =="0")
			{
				vf= true;
			}
			else if (confrimestring=="n")
			{
				vf= false;
			}
			
			return vf;
			
		}
			
		public static string RecevoirCarte()
		{			
			string mainstring="";//retour console pour que le joueur sache les carte du croupier et les sienne par exemple.
			string stringcarte1="";
			string stringcarte2="";
			
			carte1 =rand.Next(52);
			carte2 = rand.Next(52);
			
			intmain [0,0] = deckarray [0,carte1];//je donne le numero de la carte 1
			intmain [0,1] = deckarray[1,carte1];//je donne la couleur de la carte 1
			intmain [1,0] = deckarray [0,carte2];//je donne le numero de carte2
			intmain[1,1]=deckarray[1,carte2];//je donne la couleur de carte 2
			
			score = intmain[0,0]+intmain[0,1];
			
			//la methode calcule le scor et enregistre les indice du tableau du deck. ici on va renvoyer un message a l'utilisateur pour qu'il sache quel carte il a
			if(intmain[1,0]==30 | intmain[1,1]==30) // je change seulement de colone et donc seulement de carte a la ligne des couleurs
			{
				if(intmain[1,0]==30)
				{
					stringcarte1=(intmain[0,0]+"-carreaux");
				}
				if(intmain[1,0]==30)
				{
					stringcarte2=(intmain[0,1]+"-carreaux");
				}
			}
			
			if(intmain[1,0]==40 | intmain[1,1]==40) // je change seulement de colone et donc seulement de carte a la ligne des couleurs
			{
				if(intmain[1,0]==40)
				{
					stringcarte1=(intmain[0,0]+"-coeur");
				}
				if(intmain[1,0]==40)
				{
					stringcarte2=(intmain[0,1]+"-coeur");
				}
			}
			
			if(intmain[1,0]==50 | intmain[1,1]==50) // je change seulement de colone et donc seulement de carte a la ligne des couleurs
			{
				if(intmain[1,0]==50)
				{
					stringcarte1=(intmain[0,0]+"-pique");
				}
				if(intmain[1,0]==50)
				{
					stringcarte2=(intmain[0,1]+"-pique");
				}
			}
			
			if(intmain[1,0]==60 | intmain[1,1]==60) // je change seulement de colone et donc seulement de carte a la ligne des couleurs
			{
				if(intmain[1,0]==60)
				{
					stringcarte1=(intmain[0,0]+"-trèfle");
				}
				if(intmain[1,0]==60)
				{
					stringcarte2=(intmain[0,1]+"-trèfle");
				}
			}
			
			mainstring = (stringcarte1 + stringcarte2);
			return mainstring;
		}
		
		public static string JouerLaPartie(bool a)
		{
			string message1="Veuillez patienter au prochain tour pour miser";
			if(a == true)
			{
				
				string resultatRC = RecevoirCarte();
				return resultatRC;
			}
			else
			{
				return ( message1);
			}
			
		}
		
		
	}

	
}