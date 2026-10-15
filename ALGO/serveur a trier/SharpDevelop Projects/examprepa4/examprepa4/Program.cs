using System;

namespace examprepa4
{
	class Program
	{
		public static void Main(string[] args)
		{
			reservation reserv = new reservation();
			reserv.SimulationReservation();
			Console.ReadKey(true);
		}
	}
}