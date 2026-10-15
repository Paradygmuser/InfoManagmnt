using System;

namespace paldinrdrome
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("entrez un mot de votre choix : ");
            string mot = Console.ReadLine();
            bool palindrome = true;

            if (mot != null)
                for (int i = 0, j = mot.Length - 1; i < j; i++, j--)
                {
                    if (mot[i]!=mot[j])
                    {
                        palindrome = false;
                    }
                    else
                    {
                        palindrome = true;
                    }
                }

            if (palindrome == false)
            {
                Console.WriteLine("ce n'est pas un palaindrome");
            }
            else
            {
                Console.WriteLine("C'est un palindrome");
            }
        }
    }
}