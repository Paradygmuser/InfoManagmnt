using System;
using System.Collections.Generic;

namespace nouvellesolution
{
	/// <summary>
	/// Description of CardGame.
	/// </summary
	public class CardGame
	{
		public Random rand = new Random();
		public string[] colors = new string[]{"Carreau","Trèfle","Coeur","Pique"};
		public string[] valeurs = new string[13];
		public List<string> paquetDeCarte = new List<string>();
		public List<string> paquetMelanger = new List<string>();
		public List<string> player1 = new List<string>();
		public List<string> player2 = new List<string>();
		public List<string> player1InGame = new List<string>();
		public List<string> player2InGame = new List<string>();
		public List<string> equalScore = new List<string>();
		
		public void AjouterNombre(){
			int compteur=2;
			for(int i=0;i<=9;i++){
				valeurs[i]=compteur+"";
				compteur++;
			}
			valeurs[9]="Valet";
			valeurs[10]="Dame";
			valeurs[11]="Roi";
			valeurs[12]="As";
		}
		
		public void CreerJeuxDeCarte(){
			for(int i=0;i<valeurs.Length;i++){
				for(int j=0;j<colors.Length;j++){
					paquetDeCarte.Add(valeurs[i]+"-"+colors[j]);
				}
			}
		}
		
		public void AfficherCarte(){
			foreach(string n in paquetDeCarte){
        Console.WriteLine(n);//pour chaque n dans la liste affiche nameof
			}
		}
		
		public void MelangerCarte(){
			Console.WriteLine("Paquet de cartes mélangés de base");
			while(paquetDeCarte.Count>0){
				int randCard = rand.Next(0,paquetDeCarte.Count);
				paquetMelanger.Add(paquetDeCarte[randCard]);
				paquetDeCarte.RemoveAt(randCard);
			}
    }
		
		public int GetValeur(string card) {
			string cardValue = card.Split('-')[0];
			if(cardValue=="Valet"||cardValue=="Dame"||cardValue=="Roi"){
				return 10;
			}
			if(cardValue=="As"){
				return 11;
			}else{
				return Int32.Parse(cardValue);
			}
		}
		
			public int ComparerCartes(string carte1,string carte2){
			int x =3;
			if(GetValeur(carte1)>GetValeur(carte2)){
				x=0;
			}
			if(GetValeur(carte1)<GetValeur(carte2)){
				x=1;
			}
			if(GetValeur(carte1)==GetValeur(carte2)){
				x = 2;
			}
			return x;
		}

		
		
			public void Distribuer(){
			for(int i=0;i<paquetMelanger.Count;i++){
				if(i<26){
					player1.Add(paquetMelanger[i]);
				}else{
					player2.Add(paquetMelanger[i]);
				}
			}
		}
			
			
		public void Simulation(){
			while(player1.Count>0){
				string cardplayer1 = player1[0];
				string cardplayer2 = player2[0];
				int score = ComparerCartes(cardplayer1,cardplayer2);
				Console.WriteLine("Le joueur1 joue : "+cardplayer1);
				Console.WriteLine("Le joueur2 joue : "+cardplayer2);
				if(score==0){
					player1InGame.Add(cardplayer1);
					player1InGame.Add(cardplayer2);
					if(equalScore.Count>0){
						for(int i=0;i<equalScore.Count;i++){
							player1InGame.Add(equalScore[i]);
						}
						while(equalScore.Count > 0){
							equalScore.RemoveAt(0);
						}
					}
					player2.RemoveAt(0);
					player1.RemoveAt(0);
					Console.WriteLine("Le joueur 1 gagne la manche, nombre de cartes restant au joueurs "+player1.Count+"cartes");
					Console.WriteLine("le joueur 1 -> "+player1InGame.Count+" cartes dans son nouveau deck et joueur2 -> "+player2InGame.Count+" cartes");
				}
				if(score==1){
					player2InGame.Add(cardplayer1);
					player2InGame.Add(cardplayer2);
					if(equalScore.Count>0){
						for(int i=0;i<equalScore.Count;i++){
							player2InGame.Add(equalScore[i]);
						}
						while(equalScore.Count > 0){
							equalScore.RemoveAt(0);
						}
					}
					player1.RemoveAt(0);
					player2.RemoveAt(0);
					Console.WriteLine("Le joueur 2 gagne la manche, nombre de cartes restant au joueurs "+player2.Count+"cartes");
					Console.WriteLine("le joueur 1 -> "+player1InGame.Count+" cartes dans son nouveau deck et joueur2 -> "+player2InGame.Count+" cartes");
				}
				while(score==2){
					if(player1.Count < 2 || player2.Count < 2)
					{
						Console.WriteLine("Les joueurs n'ont plus assez de cartes pour jouer.");
						score=3;
						break; // Sortir de la boucle
					}
					else{
						//1ere carte jouée qui sera ajoutée au deck du gagnant
						equalScore.Add(cardplayer1);
						equalScore.Add(cardplayer2);
						player1.RemoveAt(0);
						player2.RemoveAt(0);
						
						//2eme carte jouée qui sera ajoutée au deck du gagnant
						equalScore.Add(player1[0]);
						equalScore.Add(player2[0]);
						player1.RemoveAt(0);
						player2.RemoveAt(0);
						
						cardplayer1 = player1[0];
						cardplayer2 = player2[0];
						score = ComparerCartes(cardplayer1, cardplayer2);

						Console.WriteLine("Egalité");

					}
				}
				if(score==3){
					for(int i=0; i<player1.Count;i++){
						player1.RemoveAt(i);
						player2.RemoveAt(i);
					}
				}
				//Console.WriteLine("Appuyez pour continuer");
				//string p = Console.ReadLine();
				Console.WriteLine("----------------------------------------");
			}
			int finalScorePlayer1 = 0;
			int finalScorePlayer2 = 0;
			
			for(int i=0;i<player1InGame.Count;i++){
				finalScorePlayer1+=GetValeur(player1InGame[i]);
			}
			for(int i=0;i<player2InGame.Count;i++){
				finalScorePlayer2+=GetValeur(player2InGame[i]);
			}
			if(finalScorePlayer1>finalScorePlayer2){
				Console.WriteLine("la joueur 1 a gagné la partie");
			}
			if(finalScorePlayer1<finalScorePlayer2){
				Console.WriteLine("la joueur 2 a gagné la partie");
			}
		}
		
	}
}
   