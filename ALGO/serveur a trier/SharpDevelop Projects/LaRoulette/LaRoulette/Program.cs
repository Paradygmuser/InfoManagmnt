using System;

namespace LaRoulette
{
	class Program
	{
		// j'ai fait du mieux que je peux, les il y a une chance sur deux de tomber sur une des deux couelur hormis le zero, j'ai oublié d'implementer le 0
		
		public static string zerovert="0-Vert";
		public static int [,] nombres = new int [2,36]; // on lis un tableau array 2d avec les indice [indice de ligne, indice colone]
		static Random rand= new Random();
		public static void Main(string[] args)
		{
			Tables();
			ForceDixHuit();
			PreparerTables();
			string bet = Console.ReadLine();
			Miser(bet);
			Console.ReadKey(true);
		}
		
		public static void Tables()
		{
			
			for( int i=0; i<35; i++) //Au depart je l'avais fait avec i et j dans la meme boucle mais ca ne marchait pas, j'ai aors essayé les boucle imbriquées
			{
				for(int j=0; j<35;j++)
				{
					nombres[1,j]= rand.Next(2);//pour donner aleatoirement des 1 et des 0 dans la ligne que j'attribuerais dansune autre methode
				}
		
			
		         	for(int t =0; t<36;t++)// Pour remplacer la premiere valeur 0 par 1, il n'est pas possible de commencer int t=1 car ca causera un probleme car le array a deux dimension est fixe
		         	{
		         		if(nombres[0,t]==0) //si t vaut zero, c'est un
		         		{
		         			nombres[0,t]=1;
		         		}
		         		else// si t vaut 1 ca sera 2, si t vaut 7 sa sera 8 ainsi de suite jusqu'a ce que t vallent 36 et l'itteration s'arretera
		         		{
		         			nombres[0,t]=t+1;//pas t++ cac je souhaite que la valeur de t ne change pour respecter les indice de colonnes du tableau 2d
		         		}
		         	}				
		      }
			
		}
		public static void ForceDixHuit()
		{
			int somme=0;
			for(int i=0; i<35;i++)
			{
			somme += nombres[1,i]; // je fais la somme de tout les 1 dans la ligne 1 du tableau
			}
			int force = somme-18;// je calcule la difference entre la somme our arrivé a 18
			Console.WriteLine(somme + " " + force);
			
			if(force>0)// si la differene est positive donc une somme de 1 plus grande que 18
			{
			       int c=0; // variable pour mes indic de colonne
			       
			       for(int a=0; a<force;a++) // tant que 'a' n'est pas egale(plus petit) 'force' tu boucle les instruction suivantes en iterant 'a' jusqu'a la valeur de force
			       { 
			       	for(int p=0; p<=a;p++)// je check les a premiere colones si il y a des 1 a la suite car si au pire des cas force vaut 10 c valeura 40
			         {
			       	  	while (nombres[1,c]==0)// sur la ligne deuxieme , tant que à l'indice 'c' la valeur est 0 tu rajoute 1 a c qui changera d'indice, il agit comme un filtre
                                   {
                                 	c++;
                                   }
			       	  }
                                   
                                   nombres[1,c]=0; // grace a la boucle while je suis sur qu'il changera un 1 en 0
			       	}
			}
			
			if(force<0)// si la somme des uns est plus petite que 18 alors la force sera en dessous de 0
			{
				int c=0;
				for(int p=0; p>force; p--)//tant que 'p' n'est pas egale(plus grand) 'force' tu boucle les instructions suivante en iterrant de moins 1 'p' jusqu'a ce que p soit egale a force
				{
					for(int g=0; g<=p;g++){
						while (nombres[1,c]==1)// tant que à l'indice 'c' la valeur est 1 tu rajoute 1 a 'c' qui changera d'indice, il agit comme un filtre
						{
							c++;
						}
					}
					nombres[1,c]=1;// grace a while je suis sur de changer un 0 en 1.
				}
			}			
		}
		
		public static void PreparerTables()
		{
			Console.WriteLine("voici la tabble de la roulette");
			Console.WriteLine(zerovert);
			for(int j=0;j<2;j++)
			{
				for(int t=0;t<36;t++)
				{
					Console.WriteLine(nombres[j,t]) ;
				}
				
			}
			Console.Write("Pour cloturer vos mise veuillez appuyer sur la touche de votre enchoix ensuite sur entré"); // supposant qu'il n'y ai pas de scenario alternatif , l'utilisateur appuie seulement sur 0
			
		}
		
		public static void Miser(string x)
		{
			int f = rand.Next(1,37); // je choisi un chiffre en random entre 1 et 36, 37 n'est pas compté
			 // je correspon la ligne du nombre avec la meme colone que la couleur avec l'indice f si f vaut 7 ca sera 7 et le 0 ou le 1 de Table();
		
			if(nombres[1,f]==0)
			{
				Console.WriteLine(nombres[0,f] + " -rouge");
			}
			
			if(nombres[1,f]==1)
			{
				Console.WriteLine(nombres[0,f] + " -noir");
			}
			
		}
		
	}
}