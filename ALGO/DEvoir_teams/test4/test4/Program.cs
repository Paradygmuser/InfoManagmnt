using System;

namespace test4
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("Introduisez un nombre entre 1 et 10 : ");
            int numb = Int32.Parse(Console.ReadLine());

            for (int i = 0; i <= numb; i++)
            {
                /*if (i == 0)
                {
                    Console.WriteLine("-----------");
                }
*/
                for (int j = 0; j <= i; j++)
                {
                    Console.Write ("*");
                        
                  
                }
                Console.WriteLine();

            }
        }
    }
}