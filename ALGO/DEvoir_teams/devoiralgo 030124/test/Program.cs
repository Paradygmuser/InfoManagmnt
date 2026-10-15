using System;
namespace test
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Choisissez nombre sans virgule : ");
            int n=int.Parse(Console.ReadLine());
            int counter = 1;
            
            for (int i=1; i <= n; i++)
            {
                for (int j=1; j <=n; j++)
                {
                    Console.Write(counter+ " ");
                    counter++;
                }
                Console.WriteLine();
            }
        }
    }
}