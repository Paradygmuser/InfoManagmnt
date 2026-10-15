using System;

namespace test_moyenne
{
	class Program
	{
		static Random rand = new Random();
		public static void Main(string[] args)
		{
			//tableau des notes de classe sur 20
			int [] notes = new int[19];
			//compteur de somme
			int somme=0;
			// compteur de nombre de terme car moyenne = somme des terme diviser par le nbre de terme
			int nbreterme = notes.Length;
			for (int a=0 ; a<notes.Length; a++) // attribut une valeur aleatoire a chaque colones du tableau notes.
			{
				notes[a]= rand.Next(21);
			}
			for(int i=0 ; i<notes.Length; i++)
			{
				somme +=notes[i];
			}
			
			int moyenne = somme/nbreterme;
			
			Console.WriteLine("la moyenne du tableau note est de "+moyenne+"/20");
			
			Console.ReadKey(true);
		}
	}
}