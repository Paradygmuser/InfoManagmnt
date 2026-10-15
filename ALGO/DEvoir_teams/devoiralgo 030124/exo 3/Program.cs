using System;
namespace exo_3
{
    internal class Program
    {
        public static void Main(string[] args)
        {
          Console.Write("choisissez un nombre entre 3 et 20 : ");
          string nombrestring = Console.ReadLine();
          int nombre = int.Parse(nombrestring);
          int max = 20;
          int min = 3;
          
          if (nombre>max)
          {
              Console.WriteLine(max);
              
          }

          if (nombre < min)
          {
              Console.WriteLine(min);
          }
          else if (nombre < max && nombre > min)
          {
              for (int i = 0; i < nombre; i++)
              {
                  Console.Write("*");
              }
          }
        
        }
    }
}