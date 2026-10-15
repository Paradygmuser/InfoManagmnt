using System;

namespace troisphrase
{
    internal class Program
    {
        public static void Main(string[] args)
        {
           Console.WriteLine(Calcule());
            Console.ReadKey(true);
            
        }

        public static void TroisPhrases()
        {
            Console.WriteLine("ecrivez des phrases séparer par un enter");
            string phrase1 = Console.ReadLine();
            Console.WriteLine();
            string phrase2 = Console.ReadLine();
            Console.WriteLine();
            string phrase3 = Console.ReadLine();
            Console.WriteLine("merci ca suffira.");
            Console.WriteLine("Tres bien vous avez écrit :");
            Console.WriteLine("  -"+phrase1);
            Console.WriteLine("  -"+phrase2);
            Console.WriteLine("  -"+phrase3);
            
        }
        public static int Calcule()
        {
            int a =500+500+250+ 1000+ 1000 + 1000 + 1000 + 1000 + 1000 + 1000 + 500 + 350 + 500 + 250+ 500+ 300 + 250+350+ 500+ 2000+ 350+ 350+ 500+
500+ 300+ 250 + 350 + 350 + 300 + 500 + 350 + 500 + 500 + 250 + 250 + 250 + 250 + 500 + 250 + 250 + 250 + 250 + 250 + 250 + 300 +
    250 + 1000 + 250 + 250 + 500 + 500 + 1000 + 300 + 500 + 300 + 2000 + 2000 + 2000;
            return a;
        }
    }
}