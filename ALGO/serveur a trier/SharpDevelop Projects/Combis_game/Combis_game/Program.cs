using System;
using System.IO;

namespace Combis_game
{
	class Program
	{
		Laghmich_BJ jouer= new Laghmich_BJ();
		public static void Main(string[] args)
		{
			//string nbre2 = Laghmich_BJ.LireGame() + " c'est pour tester";
			//pour tester, changer la valeur du caractere vide pour la variable dans
			//Console.WriteLine(nbre2);
			Laghmich_BJ.LireGame();
			Laghmich_BJ.PreparerJeux();
			Console.WriteLine();
			Laghmich_BJ.Jouer();
			Console.ReadKey(true);
		}
	}
	
	class Laghmich_BJ
	{
		static Random rand= new Random();
		static int essaie=4; // nombre d'essaie
		static int nombrerandint=0;// comme on va jouer avec des string je souhaite pas perdre la valeur choisi par le random
		static string stringnombre; // j'initialise la variable qui changera de caractere
		static char [] carateres = new char[6]; // mon tableau de chaque caractere sauvegarder, il sera comparer lors du jeux
		static char [] symboledevine= new char[6]; // je peux petre faire un tableau a deux diension verifiant chaque ligne de colone, mais je les commencer ainsi, je resterais avec une dimension pour comparer les indice.
		
		public static string LireGame()
		{
			/*string combisgame= File.ReadAllText("c:\repertoire/combis.game");// n'ayant pas le fichier combis.game on va juste l'imaginez avec de nombres qui prenne 6 caractere pour l'ecrire, tout ces nombre pourrait etre séparer par une virgule et je pourrait faire un split pour faire un random à l'indice sur l'array produit par split, on pourrait egallement concaténer les nombre entre eux pour faire un chiffre de 12 caracteres.*/
			
			nombrerandint = rand.Next(100000,999999);// n'ayant pas le fichier combis.game, un chiffere de 6 caractere est appelé par random
			stringnombre = (nombrerandint+"");//convertion de mon int sans reel caractere rajouter par concaténation;
			return stringnombre;
		}
		
		public static void PreparerJeux()
		{
			for (int i=0; i<stringnombre.Length; i++) // j'ai imposer la limite de 6 caractere n'ayant pas plus de consignes.
			{
				carateres[i] = stringnombre[i];// je sauvegarde chaque caractere du nombre dans le array du nombre
				symboledevine[i]='_'; // ici pour changer de symbole si on veut des * par exemples
			}
			Console.WriteLine("Devinez le nombre caché, vous avez 4 essaie");
		}
		
		public static void NombreCaché()
		{
			Console.Write("nombre caché : ");
			for(int h=0; h<carateres.Length; h++)
			{
				Console.Write(symboledevine[h]+" "); // affiche le tableau des symboles
			}	
		}
		
		public static void Jouer()
		{
			char charclient=' ';
			bool okok =false; // variable bool si il trouve un caractere caché ou non
			bool gagneratu =false; // si il gagne bool true
			string nbreclientstring;// variable pour memorisé le cahractere introduit par l'utilisateur	        
			
			Console.WriteLine("Proposer un seul chiffre et appuyer sur la touche 'entré'");// scenario nominal, on suppose que l'utilisateur entre un seul chiffre je ne ferais pas de try int32.parse pour respecter les consignes
			NombreCaché();
			Console.WriteLine();
			
			while(essaie != 0 && gagneratu==false)
			{
				Console.Write ("introduisez un nombre : ");
				nbreclientstring = Console.ReadLine();
				for(int un=0 ; un<1; un++)// seul truc pour convertir un string en char
		                {
		                	charclient = nbreclientstring[un]; // si il met plus de deux chiffre avant d'appuiyer sur entrée => error
		                }
		        	for (int b=0; b<carateres.Length; b++)// boucle pour remplacer les symboles avec le vrai caractere dans caracteres.
		        	{
		        		if(charclient==carateres[b])
		                	{
		                		symboledevine[b]= carateres[b];
		                		okok =true;
		                	}
		        	}
		        	
		        	Console.Write("Nouveaux Nombre caché: ");
		        	for(int h=0; h<symboledevine.Length; h++)
		        	{
		        		Console.Write(symboledevine[h]+" "); 
		        	}		        	
		        	Console.WriteLine();// saut a la ligne
		        	
		        	if(okok == false)
		        	{
		        		essaie =essaie - 1;
		        	}
		        	okok =false;// je remet a faux une fois qu'il a afficher le resultat, ainsi il pourra re etre verififer
		        	Console.WriteLine("il vous reste "+essaie+" essais, réintroduiser un nmbre suivie de entré");
		        	
		        	string resultat="";// pour verifié symboledevine avec chaque caractere de resultat qui se réintialise a chaque boucle while a cette ligne		        	
		        	for(int i=0 ; i<symboledevine.Length ;i++)
		        	{
		        		resultat +=symboledevine[i];
		        	}
		        	if(resultat==stringnombre)
		        	{
		        		gagneratu=true;
		        	}
			} // fin du while
			
			if (essaie == 0)
		        {
		        	Console.WriteLine("LOST");
		        }
		        
		        else if(gagneratu==true)
		        {
		        	Console.WriteLine("WIN");
		        }
		}
	}
}