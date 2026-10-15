using System;
using System.Globalization;

namespace racine_carée
{
    internal class Program
    {
        public static void Main(string[] args)
        {
            Console.Write("racine carée de : ");
            //float racande = float.Parse (Console.ReadLine());
            string racande  = Console.ReadLine();
            string[] dec_racs = racande.Split(',');
            
           
            if (dec_racs.Length == 1)
            {
                int entier =int.Parse(dec_racs[0]);
                string e = dec_racs[0];
                for (int i = 0, y=0 ; i >y ;i++,y-- )
                {
                    char [] nombre_char= new char[] nombre_char[i]:
                }
            }

            if (dec_racs.Length == 2)
            {
                int nmbrentier = int.Parse(dec_racs[0]);
                e = nmbrentier;
                int nmbrdecimal = int.Parse(dec_racs[1]);
                d= nmbrdecimal;

            }
            
        }
    }
}