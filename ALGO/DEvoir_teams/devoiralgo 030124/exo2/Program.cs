using System;
namespace exo2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Bonjour cher utilisateur");
            Console.Write("quel est votre nom? ");
            string nomstring = Console.ReadLine();
            
            int taillenom = nomstring.Length;
            int max = 10;
            int min = 6;

           if (taillenom > max)
            {
                Console.WriteLine("C'est long! Le nom doit contenir moins de " + max + " charateres");   
            }
           if (taillenom < min)
            {
                Console.WriteLine("C'est court! Le nom doit contenir plus de " + min + " charateres"); 
            }
           else if (taillenom<max && taillenom>min)
           {
               Console.WriteLine("C'est d'une taille normal!");
           }
        }
    }
}