using System;
using System.Configuration;

namespace echecier2 // je tente de crée un programme pour jouer au echec il y a plusieur class.
{
    internal class Program
    { 
        public class Pieces // classe des pieces en string elle est en aggregation faible avec l'echequier.
        {
            private string nom // attribut de la piece
            {
              string[] noms_piece = new string[6] { "pion", "fou", "cavalier", "tour", "reine", "roi" }; // le different nom des pieces.
            }

        private string couleur // atribut de la piece
        {
         string[] couleurs = new string[2] { "noir", "blanc" };
        }
        }
        public class Echecier // classe concrete principal container de classe piece
        {
            private string matiere; // mateiere de l'echequier peut etre en bois, metal, crystal...
            private int taille_cm2; // taille en 2 dimensions.
            
            public string cases() // agregattion forte avec le container echecier
            {
                protected colone () // attribut 
                {
                    char[] noms_colonnes = new char [8] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };
                }
                protected ligne() // attribut.
                {
                    int[] numeros_lignes = new int [8] { 1, 2, 3, 4, 5, 6, 7, 8 };
                }
                return Console.WriteLine(numero_ligne[Pieces()]+noms_colonne[Piece()]) // je souhaiterais que quand on demande la case , la console ecrit le nom de la case de la piece ou se trouve la case demandé.
                
            }
        
        }
}