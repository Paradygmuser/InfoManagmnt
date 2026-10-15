using System;
namespace exo_gpt_2
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Choisissez un nombre (sans virgule) : ");
            int n=int.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= n; j++)
                {
                    Console.WriteLine(i + "X" + j + "=" + (j * i));
                }
                
                Console.WriteLine();
            }
        }
    }
}