using System;
using System.Collections.Generic;

namespace CardGame2
{
	public class CardGame
	{
		//////////////////////////////////////*ATTRIBUTS*/// 
		/// </summary>
		/// 
		//List<string> nomListe = new List<string>();
		//string[] nomTableau = new string["valeur de nombre de colonnes en int pour definir la taille du tablea"];
			
		Random karimAleatoire = new Random();
		//string [] colors = new string[]; // declaration d'un tableau
		string [] colors = {"Carreaux","Coeur","Pique","Trefle"};
		string [] valeurs = new string[13];
		List<string> paquetdecarte = new List<string>();
		
		//////////////////////////////////////*Methodes*///////////////////
		/// 
		public void AjouterNombre()
		{
			for(int i=0; i<9;i++) // i=8 , i est tj plu s petit que 9 , 
			{
				valeurs[i]=(i+2)+"";// pour que la premiere valeur de mon tabeau vallent 2
			}
			valeurs[9]="Vallet";
			valeurs[10]="Dame";
			valeurs[11]="Roi";
			valeurs[12]="As";
		}
		
		public void CreerJeuxDeCarte()
		{
			for(int i=0;i<colors.Length;i++)
			{
				for(int y = 0 ; y<valeurs.Length;y++)
				{
					paquetdecarte.Add(valeurs[y]+"-"+colors[i]);
				}
			}
		}
		
		public void AfficherCartes()
		{
			for(int i  =0; i<paquetdecarte.Count;i++)
			{
				Console.WriteLine(paquetdecarte[i]);
			}
		}
		/*
		en vrai on voudrai un instruction qui prend une position aleatoire dans mon paquet de carte
		comme => paquetdecarte[karimAleatoire]=paquetdecarte;
		donc il faut genere un int pour donner la position.
		*/
		
		public List<string> MelangerCarte()
		{
			List<string> paquetMelanger = new List<string>();
			
			for(int i = 0; i<paquetdecarte.Count;i++)
			{
				int positionListe =karimAleatoire.Next(52); //Next veux dire choisi un chiffren () entre 0 et 52 non compris
				paquetMelanger[i]  = paquetdecarte[positionListe];  /*paquet de carte à la indice position liste retourne une valeur , cette dernier sera mise dans la liste paquetmelanger position i*/
			}
			
			return paquetMelanger;
		}
		
		public int Getvaleur(string parametre)
		{
			string[] splitstring = parametre.Split('-');
			
			int valeurcarte = Int32.Parse(splitstring[0]);
			
			return valeurcarte;			
		}
		
		public int Comparer(string carte1, string carte2)
		{
			int resultat=66;
			int carte1int= Getvaleur(carte1);
			int carte2int= Getvaleur(carte2);
			
			if(carte1int>carte2int)
			{
				resultat=0;
			}
			else if(carte1int<carte2int)
			{
				resultat=1;
			}
			
			else if(carte1int==carte2int)
			{
				resultat=2;
			}
			return resultat;
		}
		 
		
	}
}
