using System;
using System.Collections.Generic;

namespace Battaille_Exam
{
	public class CardGames
	{
		Random rand = new Random();    
		string[] colors = {"Trefle️","Coeur️","Carreaux️","Pique"};
		string[] valeurs = new string [13];
		
		List<string> joueur1 = new List<string>();
		List<string> joueur2 = new List<string>();
		
		List<string> paquetdejeuxT = new List<string>();
		
		public void AjouterNombres()
		{
			for (int i=0; i<valeurs.Length; i++)
			{
				
				if (i==9)
				{
					valeurs[i] = "J";
				}
				
				else if (i==10)
				{
					valeurs[i] = "Q";
				}
				else if (i==11)
				{
					valeurs[i] = "K";
				}
				else if (i==12)
				{
					valeurs[i] = "A";
				}
				else
				{
					valeurs[i] = (i+2)+""; 
					//Pour que l'As soit a la fin de la liste on commence avec le nombre 2 comme demander dans l'énocé
				}
			}
		}
		
		public void CreerJeuxDeCarte()
		{
			AjouterNombres();
			for (int i = 0; i < (colors.Length); i++)
			{
				for (int j = 0; j < (valeurs.Length); j++)
				{
					paquetdejeuxT.Add(valeurs[j]+"-"+colors[i]);
				}
			}
		}
		
		public void AfficherCartes()
		{
			CreerJeuxDeCarte();
			for (int i = 0; i < paquetdejeuxT.Count; i++)
			{
				Console.WriteLine(paquetdejeuxT[i]); // j'ai prefere mettre ca dans un tableau comme ca le random ce fait sur un tableau fixe qui bouge pas/
			}
		}
		
		public List<string> Melanger()
		{
			CreerJeuxDeCarte();
			List<string> paquetmelanger = new List<string>();
			
			for (int i = 0; i < paquetdejeuxT.Count; i++)
			{
				int r=rand.Next(paquetdejeuxT.Count);
				paquetmelanger.Add(paquetdejeuxT[r]);
				paquetdejeuxT.RemoveAt(r);
			}
			return paquetmelanger;
		}
		
		public int GetValeur(string valeur)
		{
			string [] values=valeur.Split('-');
			int result=33;
			
			if (values[0] == "J" | values[0] == "Q" | values[0] == "K")
			{
				result = 10;
			}
			else if(values[0]=="A")
			{
				result=11;
			}
			else
			{
				string valeurcarte=values[0];
				result=Int32.Parse(valeurcarte);
			}
			return result ;
		}
		
		public int ComparerCartes(string valeur1, string valeur2)
		{
			int result = 33;
			int valeurval1= GetValeur(valeur1);
			int valeurval2= GetValeur(valeur2);
			
			if (valeurval1>valeurval2)
			{
				result = 0;
			}
			else if (valeurval1 < valeurval2)
			{
				result = 1;
			}
			else if (valeurval1 == valeurval2)
			{
				result = 2;
			}
			return result;
		}
		
		public void DistribuerCarte()
		{
			List<string> paquetdejeuxM = Melanger();// normalmnt il devrait etre instancié ici
			
				for (int i=0; i<paquetdejeuxM.Count;i++)//car je ditribue 2 cartes par boucle
				{
					if(i<26) // la premiere moité je la donne au joueur 1
					{
						joueur1.Add(paquetdejeuxM[i]); //j'ajoute a liste du joueur a partir du paquetMelanger jusqu'au 25eme indice
					}
					else 
					{
						joueur2.Add(paquetdejeuxM[i]); // du 26 au 51eme indice
					}
				}
				
						
		}
		
		public void SimulerPartie()
		{
			joueur1.Clear();
			joueur2.Clear();
			DistribuerCarte();
			string cartejoueur1 = ""; //j'aurais besoin de sauvegarder la carte pour le bon déroulement de la partie
			string cartejoueur2 = "";
			int wxc = 0;// compte le nombre de carte déposé lors d'une égalité et est utile pour la suite. il sera utilisé que dans l'égalité
			int sccoorre = 66;
			/*///////////////////////////////////////////////////////*/
			Console.WriteLine("Bataille!");
			
			/////// il faut peut etre changer la condition suivante en tant que le paquet est plus grand que 3 cartes
			
			while (((joueur1.Count) !=0) | ((joueur2.Count) !=0))//tant que l'in des joueur a toujour une carte, probablement a modifé a cause de l'égalité.
			{
				
				cartejoueur1 = joueur1[0];// on range la premiere carte déposé dans une variable propre a chaque joueur.
				cartejoueur2 = joueur2[0];
				
				sccoorre = ComparerCartes(cartejoueur1,cartejoueur2);// je compare le score
				
				List<string> egaliteList = new List<string>();
				// j'y rangerais les carte déposer en plus sur la table pour une nouvelle égalité dans l'égalité.
				
				//ON RETIRE DIRECTEMENT EN DEBUT DE TOUR
				joueur1.RemoveAt(0);//retire la carte déposé du joueur1 
				joueur2.RemoveAt(0);//retire la carte déposé du joueur2
				
				//interaction console pour test.
				Console.WriteLine("Appuyer sur une touche pour le prochaine tour");
				Console.ReadLine();
				Console.WriteLine("Le joueur 1 dépose :"+ cartejoueur1); // chaque joueur affiche la premiere carte de sa liste
				Console.WriteLine("Le joueur 2 dépose :"+ cartejoueur2);//mais en vrai c'est juste pour une interaction console on est pas obligé de faire ca
				
				if (sccoorre==0)//si joueur 1 gagne
				{
					joueur1.Add(cartejoueur2);//ajoute la carte du joueur 2 a la fin de la list
					joueur1.Add(cartejoueur1);// reprend la carte a la fin de la liste
					Console.WriteLine("Le joueur 1 gagne la manche");
				}
				else if (sccoorre==1)//aussi si joueur2 gagne
				{
					joueur2.Add(cartejoueur1);//ajoute la carte du joueur 2 a la fin de la list
					joueur2.Add(cartejoueur2);// reprend la carte a la fin de la liste
					Console.WriteLine("le joueur 2 gagne la manche");
				}
				else if(joueur1.Count<=3 || joueur2.Count>=3)
				{
					Console.WriteLine("fin de partie faut faire le decompte des carte. pour savoir qui a gagner.");
				}
				while (sccoorre ==2 )//tant qu'il y a une égalité
				{
					Console.WriteLine("Egalité!! chaque joueur rajoute 2 Carte sur la table et on compare la derniere de chaque ajout");
					Console.WriteLine("Pour déposer deux carte appuyer sur n'importe quel touche");
					Console.ReadLine();
					bool findelegalite = false;// besoi de cette variable actuel pour metre fin a la boucle d'égalité.
										
					////////////////////////////////////////////////tant que l'égalité n'est pas terminer/////////////////////////
					while(findelegalite==false )
					{
						/////////////////////////////////////////////on commence par : ///////////////////////////////////////////////////
						//vu que chaque joueur dépose 2 carte il y a 4 carte sur table enplus de cartejoueur1 et 2 qui ont 
						//déja été retirer de la liste de chaque joueur en début de partie.
						//tant qu'il y a l'égalité.
						egaliteList.Add(joueur1[wxc]); // l'ordre a une tres grand importance ici pour la suite du code,car je suppose que la dernier carte déposé sera comparer. donc le joueur1 et 2 on une place dans la liste.
						egaliteList.Add(joueur2[wxc]);//on recompare les valeur avec les 2 dernier carte de la list d'égalité.
						egaliteList.Add(joueur1[wxc + 1]);
						egaliteList.Add(joueur2[wxc + 1]);
						joueur1.RemoveAt(wxc);
						joueur2.RemoveAt(wxc);
						joueur1.RemoveAt(wxc+1);
						joueur2.RemoveAt(wxc+2);
					       //////////////////////////////////////////////initialisé les nouvelle valeur a comparer////////////////////////////
					       int derniereDeLaListe = egaliteList.Count-1;
					       int avntDerniereDelaListe = egaliteList.Count-2; // quand on fait point count sur une liste de 4 carte il affichera 4, si je cherche a l'indice 4 de cette liste il n'yauras rien.
					       string compare1= egaliteList[avntDerniereDelaListe]; // correspondant a la deuxieme carte du premier joueur du dernier tour
					       string compare2= egaliteList[derniereDeLaListe];
					       Console.WriteLine("le joueur 1 a déposer en dernier le : "+compare1);
					       Console.WriteLine("le joueur 2 a deposer en dernier le : "+compare2);
						
						sccoorre = ComparerCartes(compare1,compare2);
						
						if (sccoorre==0)
					       {
							Console.WriteLine("le joueur 1 l'emporte");
							////DaboRD///
							joueur1.Add(cartejoueur2);//si il gagneajouter les carte qui ont donné la premiere egalité.
					        	joueur1.Add(cartejoueur1);
					        	
					        	/////ENSUITE//////////
					        	for (int i = 0; i < egaliteList.Count; i++)
					        	{
					        		joueur1.Add(egaliteList[i]); // si le joueur un gagne rajoute lui la list egaliter complete
					        	}
					        	findelegalite = true;
						}
						else if (sccoorre == 1)
					       {
					        	Console.WriteLine("le joueur 2 l'emporte");
					        	///////////////DABORD///////////////
					        	joueur2.Add(cartejoueur2);
					        	joueur2.Add(cartejoueur1);
					        	/////ENSUITE//////////
					        	for (int i = 0; i < egaliteList.Count; i++)
					        	{
					        		joueur2.Add(egaliteList[i]); // si le joueur deux gagne rajoute lui la list egaliter
					        	}
					        	findelegalite = true;
						}
						
						wxc+=2;
						
					}
					
					if (findelegalite == true)// si fin d'égalité on va retiré les carte du début de la liste au deux joueur, vu que le gagnant aura ganger les carte en fin de liste..
					{
						/*for (int i = 0; i < egaliteList.Count; i++) //pour chaque tout tant que i est plus petit que la taille de cette liste qui represente les carte sur la table qui seront prise par le gagnant.
						{
							joueur1.RemoveAt(i);
							joueur2.RemoveAt(i);
						//si l'égalité se termine retire moi les carte utilisé depuis l'indice 0 a savoir que les premiere carte on été retiré avant la premiere égalité. donc dans la boucle si il y a eu 2 égélaité il retirera celle qui sont apparu durant l'égalité.              
						}*/
						egaliteList.Clear();// si fin d'égalité apres la boucle clear la liste
						wxc = 0; // si fin dégalité remet le compteur a zero
					}
				}
				Console.WriteLine("il reste : "+joueur1.Count + " au joueur 1 et :"+joueur2.Count+" au joueur 2");
			}
			Console.WriteLine("La partie est terminer, l'un des joueur a son paquet vide");
		}
	}
}
	
