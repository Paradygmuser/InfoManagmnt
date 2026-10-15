using System;

namespace devoir17122024
{
  internal class Program
  {
    public static void Main(string[] args)
    {
      Console.WriteLine( "Ecrivez une phrase");
      //je veux guidé l'utilisateur sur ce qu'il doit indiqué
      //sur le programme qui présente qu'un suel ecran noir
      string phraseString = Console.ReadLine();
      //je declare une variable nommé phraseString qui correspond
      //a ce que la console va lire la phrase ecrite dans Readline
      int compteE = 0;
      //je declare un compteur du NOMBRE de lettre E
      int compteA = 0;
      //je declare un compteur du nombre de lettre A
      
      //Je fais une boucle avec for pour verifié toute les lettres de la phrase que l'on nomme indice i,
      //La premiere valeur demarre de i=0 qui correspond a la premiere lettre,
      //La derniere valeur est i<phraseString.lengt,
      //car je veux qu'une fois que la phrase est terminé la valeur de i s'arrete la boucle
      //quand il est plus grand que la longueur de la phrase 
      //puis j'ai terminé la boucle avec le type d'opération qu'il fait entre chaque indice a savoir plus 1 pour qu'il fasse l'indice de chaque lettre
      for (int i = 0; i < phraseString.Length; i++)
      {
        //if-si l'indice de la phrase est strictement egale à A
        if (phraseString[i] == 'a')
        {
          //ayant declarer le compteur des lettres A avant je peux juste dire qu'il rajoute 1 a la valeur du compteur qui est egale a zero
          compteA++;
        }
        else if (phraseString[i] == 'e')
        {
          compteE++;
        }
      }
      Console.WriteLine(("nombre de lettre a = ")+(compteA));
       // j'aime l'ordre je veux qu'il ecrive ligne par ligne avec un egale 
      Console.WriteLine(("nombre de lettre e = ")+(compteE));
      Console.ReadKey (true);
    }
  }
}