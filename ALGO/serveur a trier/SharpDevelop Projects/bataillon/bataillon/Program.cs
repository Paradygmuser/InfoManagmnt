/*
 * Created by SharpDevelop.
 * User: Admin
 * Date: 03-06-25
 * Time: 20:02
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Collections.Generic;
namespace bj_test
{
class Program
    {
public static void Main(string[] args)
        {
            CardGame.AjouterNbr();
            CardGame.CreerJeuxDeCarte();
            CardGame.Melanger();
            //CardGame.AfficherCartes();
            CardGame.GetValeur("Roi-pique");
            CardGame.Distribuer();
            CardGame.Simulation();
            //Console.WriteLine("Valeur de 'As-Coeur' : " + CardGame.GetValeur("As-Coeur"));
            //Console.WriteLine("Valeur de '5-Carreau' : " + CardGame.GetValeur("5-Carreau"));
            Console.ReadKey(true);
        }
}

class CardGame 
{
        static Random rand = new Random();
        static string[,] jeux = new String[2,52];
        static string[] colors = new String[] {"Carreau","Coeur","Pique","Trèfle"};
        static string[] valeurs = new String[13];
        static List<string> paquetDeCartes = new List<string>();
        static List<string> paquetDeCartesMelanger = new List<string>();
        static List<string> joueur1 = new List<string>();
        static List<string> joueur2 = new List<string>();
        
        public static void AjouterNbr()
        {
        	int compteur=2;
        	for(int i=0; i<9; i++)
        	{
        		valeurs[i]=compteur+"";
                      compteur++;
        	}
        	valeurs[9] = "Valet";
               valeurs[10] = "Dame";
               valeurs[11] = "Roi";
               valeurs[12] = "As";
        }
                
        public static void CreerJeuxDeCarte()
        {
        	for(int i=0; i<=12;i++)
        	{
        		for(int j=0; j<=3;j++)
        		{
        			paquetDeCartes.Add(valeurs[i]+"-"+colors[j]);
        		}
        	}
        }
                
        public static void AfficherCartes()
        {
        	foreach(string n in paquetDeCartesMelanger)
        	{
        		Console.WriteLine(n);
        	}
        }
                
        public static List<string> Melanger()
        {
        	while (paquetDeCartes.Count > 0) 
        	{
        		int randCard = rand.Next(0, paquetDeCartes.Count);
                      paquetDeCartesMelanger.Add(paquetDeCartes[randCard]);
                      paquetDeCartes.RemoveAt(randCard);
        	}
        	return paquetDeCartesMelanger;
        }       
                
        public static int GetValeur(string maCarte)
        {
        	string valeurDeLaCarte = maCarte.Split('-')[0];
        	if(valeurDeLaCarte=="Valet" || valeurDeLaCarte=="Dame" || valeurDeLaCarte=="Roi"|| valeurDeLaCarte=="As")
        	{
        		return 10;
        	}
        	else
        	{
        		return Int32.Parse(valeurDeLaCarte);
        	}
        }
                
        public static int GetCompare(string carte1,string carte2)
        {
        	int aa= 33;
        	if(GetValeur(carte1)>GetValeur(carte2))
        	{
        		aa=0;
        	}
        	
        	else if(GetValeur(carte1)<GetValeur(carte2))
        	{
        		aa=1;
        	}
        	else if(GetValeur(carte1)==GetValeur(carte2))
        	{
        		aa=2;
        	}
        	return aa;
        }
        
        public static void Distribuer(){
        for(int i=0; i<paquetDeCartesMelanger.Count;i++){
        if(i<26){
                            joueur1.Add(paquetDeCartesMelanger[i]);
                        }if(i>25){
                            joueur2.Add(paquetDeCartesMelanger[i]);
                        }
                    }
                    /*foreach(string n in joueur1){
                    Console.WriteLine("joueur 1 :"+ n);
                    }*/
                }
                
        public static void  Simulation()
        {
        	do
        	{
        		string carteJouer1 = joueur1[0];
        		string carteJouer2 = joueur2[0];
                       //string carteJouer = joueur1[2];
                       //string carteJouer = joueur2[2];
                       int score = GetCompare(joueur1[0],joueur2[0]);
                       Console.WriteLine(carteJouer1);
                       Console.WriteLine(carteJouer2);
                       
                       if(score==0)
                         {
                       	joueur1.RemoveAt(0);
                       	joueur2.RemoveAt(0);
                                joueur1.Add(carteJouer1);
                                joueur1.Add(carteJouer2);
                                
                         		Console.WriteLine("le joueur 1 avait ="+ carteJouer1);
                         		Console.WriteLine("le joueur 2 avait ="+carteJouer2);
                                Console.WriteLine("Le joueur 1 remporte le tour");
                         }
        	         
                         else if(score==1)
                         {
                         	joueur1.RemoveAt(0);
                         	joueur2.RemoveAt(0);
                                joueur2.Add(carteJouer1);
                                joueur2.Add(carteJouer2);
                                
                         		Console.WriteLine("le joueur 1 avait =" + carteJouer1);
                         		Console.WriteLine("le joueur 2 avait ="+carteJouer2);
                                Console.WriteLine("Le joueur 2 remporte le tour");
                         }
                         
                         while(score==2)
                         	{
                         		Console.WriteLine("Egalité!, pour redéposer 2 cartes appuyer sur n'mporte quel touches");
                         		Console.ReadLine();
                         		int i=0;
                         		carteJouer1 = joueur1[i+2];
                         		carteJouer2 = joueur2[i+2];
                         		score = GetCompare(carteJouer1,carteJouer2);
                         		i+=2;
                         		Console.WriteLine("le joueur 1 avait =" + carteJouer1);
                         		Console.WriteLine("le joueur 2 avait =" + carteJouer2);
                         		if(score==0)
                         		{
                         			for(int j=0; i>=0 ; j++)
                         			{
                         				joueur1.Add(joueur1[i]);
                         				joueur1.Add(joueur2[i]);
                         				joueur1.RemoveAt(j);
                         				joueur2.RemoveAt(j);
                         				i--;
                         			}
                         			Console.WriteLine("Le joueur 1 remporte le tour");
                         		}
                         	      else if(score==1)
                         	      {
                         	      	        for(int j=0; i>=0 ; j++)
                         	      	        {
                         	      	        	joueur2.Add(joueur2[i]);
                         	      	        	joueur2.Add(joueur1[i]);
                         	      	        	joueur1.RemoveAt(j);
                         	      	        	joueur2.RemoveAt(j);
                         	      	        	i--;
                         	      	        }
                         	      	        Console.WriteLine("Le joueur 2 remporte le tour");
                         	      }
                         	      else
                         	      {
                         	      	    for(int gg=0; gg<=i;gg++)
                         	      	    {
                         	      	    	joueur1.RemoveAt(gg);
                         	      	    	joueur2.RemoveAt(gg);
                         	      	    }
                         	      }
                         	      
                         	
                         }
                         
                         Console.WriteLine("Pret pour le prochain tour? seul reponse autorisé'nimporte quel touche'");
                         Console.WriteLine("il reste "+joueur1.Count +" cartes au joueur 1 et "+ joueur2.Count +" cartes au joueur 2");
                         Console.ReadLine();
        	}
                while(joueur1.Count>=1 || joueur2.Count>=1);
                if(joueur1.Count==0)
                {
                	Console.WriteLine("Le joueur 1 n'a plus de carte");
                }
                
                if(joueur2.Count==0)
                {
                	Console.WriteLine("Le joueur 2 n'a plus de carte");
                	
                }
        }
}
}