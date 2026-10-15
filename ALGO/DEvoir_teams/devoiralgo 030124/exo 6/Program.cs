using System;

namespace exo_6
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("choisissez un nombre (sans virgule): ");
            string ns = Console.ReadLine();
            int n=int.Parse(ns);

            if (n == 0)
            {
                Console.WriteLine("Ca ne fonctionne pas avec Zero");
            }
            for (int i = 1; i <= n; i++)
            {
                for (int ii = 0; ii < i; ii++)
                { 
                    Console.Write("*"); 
                } 
                Console.WriteLine();
            }
        }
    } 
}