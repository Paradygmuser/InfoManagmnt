/*
 * Created by SharpDevelop.
 * User: Enael
 * Date: 23-06-25
 * Time: 14:32
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;

namespace test_qcm
{
	class Program
	{
		public static void Main(string[] args)
		{
			string concatenstring = Concatener("salut", "cava", "oui?");
			Console.WriteLine(concatenstring);
			Console.ReadKey(true);
		}
		
		public static string Concatener(string a, string b, string c)
		{
			string resultat = a+b+c;
			return resultat;
		}
	}
}