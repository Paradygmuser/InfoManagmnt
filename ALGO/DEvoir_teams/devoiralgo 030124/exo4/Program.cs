using System;

namespace exo4
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Choisissez un nombre : ");
            string nombreString = Console.ReadLine();
            int n = int.Parse(nombreString);
            if (n%2 == 0)
            {
                Console.WriteLine("c'est un nombre paire! ");
            }
            if (n%2 != 0)
            {
                Console.Write("C'est un nombre impaire! ");
            }
            if(n%3 ==0) 
            { 
                Console.WriteLine("Et ce nombre est divisible par 3!");
            }
            
            int nombrecaré = n * n;
            Console.Write("Voici son carré : ");
            Console.WriteLine(nombrecaré);
            
            int zerocount = 0;
            char zero = '0';
            for(int i =0; i<=nombreString.Length; i++)
            {
                if (i == zero)
                {
                    zerocount++;
                }
            }
            if (zerocount == 0)
            {
                Console.WriteLine("il n'y a aucun Zéro dans ton nombre");
            }
            else if (zerocount != 0)
            {
                Console.WriteLine("ton nombre contient "+ zerocount + " fois zéro");
            }
        }
    }
}