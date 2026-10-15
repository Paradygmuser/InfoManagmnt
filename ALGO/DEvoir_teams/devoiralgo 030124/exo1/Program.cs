using System;
//framework 4.8
namespace exo1
{
    internal class Program
    {
        public static void Main(string[] args)
        {
           Console.WriteLine("Bonjour cher utilisateur");
           Console.Write("quel est votre nom? ");
           string nom = Console.ReadLine();
           Console.Write("quel est votre prenom? ");
           string prenom = Console.ReadLine();
           
           Console.WriteLine(" ");
           Console.WriteLine("Vous vous appelez "+ prenom +" " +nom);
           Console.ReadKey(true);
        }
    }
}