/*
 * Created by SharpDevelop.
 * User: kastit
 * Date: 10-06-25
 * Time: 23:58
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;

namespace CardGame
{
	class Program
	{
		public static void Main(string[] args)
		{
			CardGame cd = new CardGame();
			
			cd.Card();
			cd.AddCardToGame();
			cd.ShowCard();
			cd.ShakeCard();
			cd.GetValue("As-Pique");
			cd.ShareCards();
			Console.WriteLine("------------------------");
			cd.Simulation();
			Console.ReadKey(true);
		}
	}
}