/*
 * Created by SharpDevelop.
 * User: kastit
 * Date: 13-06-25
 * Time: 18:17
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Collections.Generic;

namespace ExoBJ
{
	class Program
	{
		public static List<string> paquet = new List<string>();
		public static List<string> paquetMelange = new List<string>();
		public static int miseInt =0;
		public static int[] carteAs = new int[2];
		public static List<string> croupier = new List<string>();
		public static List<string> joueur = new List<string>();
		public static List<string> joueurBis = new List<string>();
		public static string[] valeurs = new string[13];
		public static Random rand = new Random();
		
		public static void Main(string[] args)
		{
			CreerCartes();
			MelangeCartes();
			Mise();
			Jeux();
			Console.ReadKey(true);
		}
		public static void CreerCartes(){
			string[] couleurs = new string[]{"Carreau","Coeur","Trèfle","Pique"};
			for(int i=0;i<9;i++){
				valeurs[i]=i+2+"";
			}
			valeurs[9]="Valet";
			valeurs[10]="Dame";
			valeurs[11]="Roi";
			valeurs[12]="As";
			for(int i=0;i<couleurs.Length;i++){
				for(int j=0;j<valeurs.Length;j++){
					paquet.Add(valeurs[j]+"-"+couleurs[i]);
				}
			}
		}
		public static void MelangeCartes(){
			while(paquet.Count>0){
				int randomCarte = rand.Next(0,paquet.Count);
				paquetMelange.Add(paquet[randomCarte]);
				paquet.RemoveAt(randomCarte);
			}
		}
		public static void Mise(){
			Console.WriteLine("Entrez votre mise");
			string mise = Console.ReadLine();
			miseInt = Int32.Parse(mise);
		}
		public static int GetValeur(string cartePoint){
			int result=0;
			string valeurDeLaCarte = cartePoint.Split('-')[0];
			if(valeurDeLaCarte=="Valet" || valeurDeLaCarte=="Dame" || valeurDeLaCarte=="Roi"){
				result=10;
			}
			else if(valeurDeLaCarte=="As"){
				result=11;
			}
			else{
				result=Int32.Parse(valeurDeLaCarte);
			}
			return result;
		}
		public static void Jeux(){
			int miseIntBis = miseInt;
			int score=0;
			int scoreBis=0;
			int scoreCroupier=0;
			string splitVerif = "";
			for(int i=0;i<2;i++){
				joueur.Add(paquetMelange[0]);
				croupier.Add(paquetMelange[1]);
				paquetMelange.RemoveAt(1);
				paquetMelange.RemoveAt(0);
			}
			for(int i=0;i<joueur.Count;i++){
				score+=GetValeur(joueur[i]);
			}
			for(int i=0;i<croupier.Count;i++){
				scoreCroupier+=GetValeur(croupier[i]);
			}
			Console .WriteLine("joueur :"+joueur[0]+" / "+joueur[1]+" -> "+score);
			Console.WriteLine("croupier :"+croupier[0]+" / carte cachée -> "+GetValeur(croupier[0]));
			Console.WriteLine("Voulez-vous séparer vos cartes ? entrez oui ou non (si oui, votre mise augmentera de 2 automatiquement)");
			string askSplit = Console.ReadLine();
			if(askSplit=="oui"){
				splitVerif = "oui";
				score=0;
				scoreBis=0;
				joueurBis.Add(joueur[1]);
				joueur.RemoveAt(1);
				joueur.Add(paquetMelange[0]);
				joueurBis.Add(paquetMelange[1]);
				paquetMelange.RemoveAt(1);
				paquetMelange.RemoveAt(0);
				for(int i=0;i<joueur.Count;i++){
					score+=GetValeur(joueur[i]);
				}
				for(int i=0;i<joueurBis.Count;i++){
					scoreBis+=GetValeur(joueurBis[i]);
				}
				Console.WriteLine("cartes après séparation");
				Console.WriteLine("------------ main 1 ------------");
				foreach(string n in joueur){
					Console .WriteLine(n);
				}
				Console.WriteLine("total : "+score);
				Console.WriteLine("------------ main 2 ------------");
				foreach(string n in joueurBis){
					Console .WriteLine(n);
				}
				Console.WriteLine("total : "+scoreBis);
				Console.WriteLine("Tirer des cartes pour la main 1 ? oui/non");
				string askTirer = Console.ReadLine();
				while(askTirer=="oui" && score<21){
					score=0;
					joueur.Add(paquetMelange[0]);
					paquetMelange.RemoveAt(0);
					for(int i=0;i<joueur.Count;i++){
						score+=GetValeur(joueur[i]);
					}
					Console.WriteLine(joueur[joueur.Count-1]);
					Console.WriteLine("valeurs cumulées des cartes "+score);
					if(score<21){
						Console.WriteLine("Retirer ? oui/non");
						askTirer = Console.ReadLine();
					}
				}
				if(askTirer=="non"){}
				Console.WriteLine("Tirer des cartes pour la main 2 ? oui/non");
				string askTirerBis = Console.ReadLine();
				while(askTirerBis=="oui" && scoreBis<21){
					scoreBis=0;
					joueurBis.Add(paquetMelange[0]);
					paquetMelange.RemoveAt(0);
					for(int i=0;i<joueurBis.Count;i++){
						scoreBis+=GetValeur(joueurBis[i]);
					}
					Console.WriteLine(joueurBis[joueurBis.Count-1]);
					Console.WriteLine("valeurs cumulées des cartes "+scoreBis);
					if(scoreBis<21){
						Console.WriteLine("Retirer ? oui/non");
						askTirerBis = Console.ReadLine();
					}
				}
				if(askTirerBis=="non"){}
			}
			if(askSplit=="non"){
				splitVerif = "non";
				Console.WriteLine("Tirer des cartes ? oui/non");
				string askTirer = Console.ReadLine();
				while(askTirer=="oui" && score<21){
					score=0;
					joueur.Add(paquetMelange[0]);
					paquetMelange.RemoveAt(0);
					for(int i=0;i<joueur.Count;i++){
						score+=GetValeur(joueur[i]);
					}
					Console.WriteLine(joueur[joueur.Count-1]);
					Console.WriteLine("valeurs cumulées des cartes "+score);
					if(score<21){
						Console.WriteLine("Retirer ? oui/non");
						askTirer = Console.ReadLine();
					}
				}
				if(askTirer=="non"){}
			}
			if(joueurBis.Count==0){
				while(scoreCroupier<18 && score<22){
					scoreCroupier=0;
					croupier.Add(paquetMelange[0]);
					paquetMelange.RemoveAt(0);
					for(int i=0; i<croupier.Count;i++){
						scoreCroupier+=GetValeur(croupier[i]);
					}
				}
				Console.WriteLine("Cartes du croupier :");
				foreach(string n in croupier){
					Console.Write(n+" ");
				}
			}
			if(joueurBis.Count>0){
				while((scoreCroupier<18 && scoreCroupier<score && score<22) || (scoreCroupier<18 && scoreCroupier<scoreBis && scoreBis<22)){
					scoreCroupier=0;
					croupier.Add(paquetMelange[0]);
					paquetMelange.RemoveAt(0);
					for(int i=0; i<croupier.Count;i++){
						scoreCroupier+=GetValeur(croupier[i]);
					}
				}
				Console.WriteLine("Cartes du croupier :");
				foreach(string n in croupier){
					Console.Write(n+" ");
				}
			}
			Console.WriteLine("");
			if (splitVerif == "oui")
			{
				bool main1Valid = score <= 21;
				bool main2Valid = scoreBis <= 21;
				bool croupierBust = scoreCroupier > 21;
				if (croupierBust){
					Console.WriteLine("Vous avez gagné, le croupier a dépassé 21. Gain : " + ((miseInt * 2) + (miseIntBis * 2)));
				}
				else{
					if (main1Valid && score > scoreCroupier && main2Valid && scoreBis > scoreCroupier){
						Console.WriteLine("Vous remportez les 2 mains. Gain : " + ((miseInt * 2) + (miseIntBis * 2)));
					}
					else if (main1Valid && score > scoreCroupier && (!main2Valid || scoreBis < scoreCroupier)){
						Console.WriteLine("Vous remportez la 1ère main et perdez la 2ème. Gain : " + (miseInt * 2));
					}
					else if ((!main1Valid || score < scoreCroupier) && main2Valid && scoreBis > scoreCroupier){
						Console.WriteLine("Vous remportez la 2ème main et perdez la 1ère. Gain : " + (miseIntBis * 2));
					}
					else if (!main1Valid && !main2Valid){
						Console.WriteLine("Vous perdez les 2 mains.");
					}
					else if (score == scoreCroupier && scoreBis == scoreCroupier){
						Console.WriteLine("Les 2 mains sont en égalité avec le croupier.");
					}
					else if (score == scoreCroupier && scoreBis > scoreCroupier && main2Valid){
						Console.WriteLine("Main 1 égalité, main 2 gagnée. Gain : " + (miseIntBis * 2));
					}
					else if (scoreBis == scoreCroupier && score > scoreCroupier && main1Valid){
						Console.WriteLine("Main 2 égalité, main 1 gagnée. Gain : " + (miseInt * 2));
					}
					else{
						Console.WriteLine("Aucune main gagnante.");
					}
				}
			}
			else{ // splitVerif == "non"
				if (score > 21){
					Console.WriteLine("Perdu, vous avez dépassé 21.");
				}
				else if (scoreCroupier > 21){
					Console.WriteLine("Croupier dépassé, vous avez gagné. Gain : " + (miseInt * 2));
				}
				else if (score > scoreCroupier){
					Console.WriteLine("Gagné, gain : " + (miseInt * 2));
				}
				else if (score == scoreCroupier){
					Console.WriteLine("Égalité.");
				}
				else{
					Console.WriteLine("Perdu.");
				}
			}
		}
	}
}