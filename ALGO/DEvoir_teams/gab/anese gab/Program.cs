using System;
using System.Collections.Generic;

namespace AL_010425_algo
{
    class Program
    {
        private static int montant;
        private static int arrondi;
        public static void Main(string[] args)
        {
            Demandermontant();
            Arrondi(montant);
            Console.WriteLine("votre montant arrondi est "+ Arrondi(montant));
            PrepaCoupure(arrondi);
            Console.ReadKey(true);
        }
        public static void Demandermontant()
        {
            Console.WriteLine("saisi le montant à retirer");
            string Cmontantstring = Console.ReadLine();
            montant = Int32.Parse(Cmontantstring);
            while (montant>500 | montant <1)
            {
                Console.WriteLine("votre montant dépasse la limite autorisé, veuillez réintroduire un montant compris entre 1 et 500 euros");
                Cmontantstring = Console.ReadLine();
                montant = Int32.Parse(Cmontantstring);
            }
        }
        public static int Arrondi(int m)
        {
            while(m%5!=0)
            {
                m++;
                arrondi =m;
            }
            arrondi = m;
            return arrondi;
        }
        public static void PrepaCoupure(int a)
        {		
            int b_cinquantes;// attributs propre a la methode, nomclanture : billet_nbrsurbillet
            int rest50;//attribut du restant de l'arrondi propre a la methode', nomenclature ex rest50 
            int b_vingt;
            int rest20;
            int b_dix;
            int rest10;
            int b_cinq;
                b_cinquantes = a/50;
                rest50 = a%50;
                Console.WriteLine("vous recevrez "+b_cinquantes+" billets de 50");
                b_vingt= rest50/20;
                rest20= rest50 %20;
                Console.WriteLine("vous recevrez "+b_vingt+" billets de 20");
                b_dix= rest20/10;
                rest10= rest20 %10;
                Console.WriteLine("vous recevrez "+b_dix+" billets de 10");
                b_cinq = rest10/5;
                Console.WriteLine("vous recevrez "+b_cinq+" billets de 5");
        }
    }
}