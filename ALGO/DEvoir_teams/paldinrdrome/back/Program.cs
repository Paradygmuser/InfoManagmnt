using System;
using System.Threading;

namespace back
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Clear();
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.ForegroundColor = ConsoleColor.Black;
            Console.WriteLine("HEY SALUT");
            Thread.Sleep(2000);
            Console.ResetColor();
            Console.Clear();
            
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.Black;
            Console.WriteLine("ouai salut, bof");
            Thread.Sleep(3000);
            Console.ResetColor();
            Console.Clear();
            
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.ForegroundColor = ConsoleColor.Black;
            Console.WriteLine("qu'est ce qui t'arrive?");
            Console.WriteLine("tu ne te sens plus à l'aise?");
            Thread.Sleep(3000);
            Console.ResetColor();
            Console.Clear();
            
            Console.BackgroundColor = ConsoleColor.DarkGreen;
            Console.ForegroundColor = ConsoleColor.Black;
            Console.WriteLine("un peu ce monde devient");
            Console.WriteLine("difficillement insupportable");
            Thread.Sleep(3200);
            Console.WriteLine("tous le monde veut se faire la guerre");
            Thread.Sleep(4200);
            Console.ResetColor();
            Console.Clear();
            
            Console.BackgroundColor = ConsoleColor.DarkBlue;
            Console.ForegroundColor = ConsoleColor.Black;
            Console.WriteLine("Tout ira mieux! ");
            Thread.Sleep(1500);
            Console.Write("concentre ");
            Thread.Sleep(300);
            Console.Write("toi ");
            Thread.Sleep(400);
            Console.Write("sur ");
            Console.Write("tes objectifs!");
            Thread.Sleep(5000);
            Console.ResetColor();
            Console.Clear();
            
            Console.BackgroundColor = ConsoleColor.DarkGreen;
                        Console.ForegroundColor = ConsoleColor.Black;
                        Console.Write("   ");
                        Thread.Sleep(1200);
                        Console.WriteLine("...");
                        Thread.Sleep(3200);
                        Console.WriteLine("Ce sentir rejeté et sans un rond, y a pas moyen de s'y concentré");
                        Thread.Sleep(4200);
                        Console.ResetColor();
                        Console.Clear();
        }
    }
}