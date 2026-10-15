using System;
using Battaille_Exam;

namespace Bataille_Exam
{
	class Program
	{
		

		public static void Main(string[] args)
		{
			CardGames cardGames = new CardGames();
			
			cardGames.AfficherCartes();
			cardGames.SimulerPartie();			
			Console.ReadKey(true);
		}
	}
}