using System;

namespace nouvellesolution
{
	class Program
	{
		public static void Main(string[] args)
		{
			
			CardGame carte = new CardGame();
			
			carte.AjouterNombre();
			carte.CreerJeuxDeCarte();
			carte.AfficherCarte();
			
			Console.ReadKey(true);
		}
	}
}