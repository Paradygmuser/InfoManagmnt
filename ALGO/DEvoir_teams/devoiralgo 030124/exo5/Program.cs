using System;

namespace exo5
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            // je ne sais pas comment convertir un sting contenant une virgule vers un int
            Console.Write("Quel est le diamètre?(san virgule et en cm) : ");
            string diaString = Console.ReadLine();
            int dia = Int32.Parse(diaString);
            /*
             permiètre d'un cercle 2 x pi x r
             surface d'un cercle pi x r^2
            */
            float PI = (float) 3.14159265359 ;
            float r = (float)dia / 2;
            float perimetre = (2 * PI * r);
            /*
            ne sachant pas trouvé d'explication claire sur les exposant 
            j'ai just fait r x r pour l'exposant 2 je ne trouve pas d'explication clair sur microsoft
            on y dit qu'il faut utilisé un public math? 
            */
            float surface = (PI * (r * r));
            Console.WriteLine("Son permiètre est de : " + perimetre+ " cm");
            Console.WriteLine("Sa surface est de : " + surface+ " cm2");
            //comment limité le nombre de decimal apres la virgule?
        }
    }
}