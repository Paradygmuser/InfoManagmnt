using System;
using System.Collections.Generic;
using System.Linq.Expressions;

namespace ConsoleApplication2
{
    internal class Program
    {
        private static List<string> hautescartes = new List<string>();
        private static List<string> couleurcartes = new List<string>();
        private static List<int> numerocartes = new List<int>();
        private static Random rand = new Random();
        
        public static void Main(string[] args)
        {
            NumeroCartes();
            Couleurs();
            HautesCartes();
            for (int i = 0,j=0,k=13; i < 13; i++, j++,k--)
            {
                int u = 0;
                if (i > 10 && j%13==0)
                {
                    u++;
                    Console.WriteLine(hautescartes[k]+couleurcartes[u]);
                    
                }
                else
                {
                    Console.WriteLine(numerocartes[i]+couleurcartes[u]);
                }
            }
        }

        public static void NumeroCartes() 
        {
            for (int i = 1; i <= 10; i++)
            {
                numerocartes.Add(i);
            }
        }

        public static void Couleurs()
        {
            couleurcartes.Add("Carreaux");
            couleurcartes.Add("Coeurs");
            couleurcartes.Add("Piques");
            couleurcartes.Add("Trefles");
        }

        public static void HautesCartes()
        {
            hautescartes.Add("Vallet");
            hautescartes.Add("Reine");
            hautescartes.Add("Roi");
        }
    }
}