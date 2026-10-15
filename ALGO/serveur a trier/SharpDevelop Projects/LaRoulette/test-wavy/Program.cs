
using System;
using System.Collections.Generic;

namespace test_wavy
{
	class Program
	{
		
		public static void Main(string[] args)
		{
			int [] notes = {15,10,9,4,18};
			string [] noms = {"Jean-batptoste","marinade","yahzuz toutjour de la yahouz","rachid","william"};
			
			int max=0;
			
			
			for (int i=0; i<notes.Length ; i++)
			{
				max +=notes[i];
			}
			
			int denominateur = 100;
			int moyenne = max/denominateur;
			
			Console.WriteLine(moyenne);
			
			Console.ReadKey(true);
		}
	}
}