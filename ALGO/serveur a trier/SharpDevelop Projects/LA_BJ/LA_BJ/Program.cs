/*
 * Created by SharpDevelop.
 * User: Enael
 * Date: 09-06-25
 * Time: 18:51
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Collections.Generic;
using System.IO;

namespace LA_BJ
{

	class Program
	{ 
		static Random rand= new Random();
		public static void Main(string[] args)
		{
			/*/////////LIRE FICHER EXTERNE///////*/
			List <string> listdemot = new List<string>();
			using (StreamReader streamreader = new StreamReader(@"c:\temp\motliste.txt"))
			{
				string line;
				while((line=streamreader.ReadLine()) != null)
				{
					listdemot.Add(line);
				}
			}
			
			/*/////////////////////////CE DONT ON A BESOIN POUR LA PARTIE//////////////////*/
			
			//grace aux algorithme donné par le prof nous avons directement une liste de mots
			//nous allons choisir un mot au hazard dans la liste de mot pour le jeux selone la taille de la liste de mot
			
			string [] listarray = listdemot[0].Split(' ');
			int r = rand.Next(listarray.Length); // le .Next() choisira un nombre entre 0 et le nombre avant .Le,gth (dans notre texte on une 35 mot et bien le .Coutn donne 35 mais on a besoin que jusqu'a l'indice 34 car l'indice 0 de notre list est utilisé.
			string motchoisi = listarray[r]; // je range le mot choisi dans une variable.
			int essaie = 10; // le nombre d'essaie
			/*////////////////////////////////////////////LE JEUX///////////////////////////////////////////////////////////*/
			//Je commence par déclarer un tableau fixe qui au la longueur du mot, chaque colone sera une lettre
			
			string [] motdejeux = new string[motchoisi.Length];
			string [] devine = new string[motchoisi.Length];// un tableau de comparaison qui enregistrera les lettre proposer
			//bool findejeux=false;//ool me permettant d'arreter une boucle while
			
			Console.WriteLine("Devinez le mot du jour"); // interaction console
			
			for(int i=0;i<motdejeux.Length-1;i++)
			{
				//je profite de cette boucle pour ranger chaque lettre dans les tables
				motdejeux[i]=motchoisi[i]+"";// la table mot de jeux enregistre la lettre d mot choisi par le random
				devine[i]="_";// dans mon imaginaire le tableau porte au deart de la partie que des underscore
				Console.Write("_ "); // j'ecris le underscor au tant qe la longueur du mot
			}
			while(essaie>0)
			{
				Console.WriteLine();//je souhaite une ligne entre
				Console.WriteLine("quel lettre proposez-vous?(tappez une seul lettre! pour certain mots les accents compte!) : ");
				string stringcharchoisi = Console.ReadLine();//interaction console on demande a l'utilisateur de choisir une lettre
				//je fais une boucle pour retenir que la premiere lettre
				for(int i=0;i<1;i++)
				{
					stringcharchoisi = stringcharchoisi[0]+"";// j'ecrase le precedent string par ce celui qui n'a plus qu'un caractère
				}
				
				for(int i=0;i<motdejeux.Length-1;i++)
				{
					// je force le string en concaténant le char a l'indice i et ""
					if(stringcharchoisi == motdejeux[i]) //si une lettre est ok
					{
						devine[i]=stringcharchoisi;// si l'utilisateur trouve la lettre le tableau 'devine ' cahnge le caractere a l'indice i
						Console.Write(devine[i]+" ");// a la valeur i il ecrit le caractere mot caché bien que je l'ai stocjé dans une variable string je suppose partir du scenario nominal ou l'utilisateur entre une seul caractère de type lettre.
					}
					else // sinon ecrit underscor a l'indice i
					{
						Console.Write(devine[i]+" ");
					}
				}
				
						
				essaie--;
				
				Console.WriteLine("il vous reste "+essaie+"essaies.");
			}
			Console.WriteLine("//////////////////////////////////////////////////La partie est terminé//////////////////////////////////////////////////////////////");
			Console.ReadKey(true);
		}
			
		}
}
	
	
	/*class LA_BJ
	{


	}*/
