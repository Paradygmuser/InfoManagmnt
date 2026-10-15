using System;
//using CardGame.cs;

namespace CardGame2
{
	class Program
	{
		public static void Main(string[] args)
		{
			CardGame carte = new CardGame();
			carte.AfficherCartes();
			Console.ReadKey(true);
		}
	}
}