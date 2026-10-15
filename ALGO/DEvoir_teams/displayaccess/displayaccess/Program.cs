/* Dans un scénario nominal sans enchainement alternatif et sans prise de sécurité en répondant purement a la question*/
using System;

namespace displayaccess
{
    internal class Program
    {
        private static int pin=4747;
        public static void Main(string[] args)
        {
            DisplayMenu();
            string choixstring = Console.ReadLine();
            if (choixstring == "1")
            {
                Console.WriteLine(pin);
            }
            else
            {
                Console.WriteLine("Error");
            }
            int choix = Int32.Parse(choixstring);
            switch (choix)
            {
                case 1:
                    Console.WriteLine(pin);
                    break;
                case 2:
                    Console.WriteLine("Error");
                    break;
            }
        }

        public static void DisplayMenu()
        {
            Console.WriteLine("*********************");
            Console.WriteLine("1. Voir Code Pin");
            Console.WriteLine("2. Voire Solde Compte Bancaire");
            Console.WriteLine("*********************");
        }
    }
}