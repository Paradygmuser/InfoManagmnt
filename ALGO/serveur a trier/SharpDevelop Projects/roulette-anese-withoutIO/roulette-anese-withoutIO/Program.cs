
using System;
using System.Collections.Generic;

namespace roulette_anese_withoutIO
{
	class Program
	{
		/*//Attributs pour la table//*/
		static Random rand = new Random();// déclaration de l'attribut random
		static List<string> couleurs = new List<string>(); // délaration de la liste des couleur comprtant uniquement les 18 rouge et noir
		static string [,] tableroulette = new string[2,37] ;// table roulette utilisé pour la boue qui tombe
		static string bouleconcat; //attribut pour ranger la valeur de la boule qui tombe
		static int truerandom;//attribue random pour chaque toure de boule
		/*//Attributs pour le jouer//*/
		static int solde=200;//declaration et assignation de l'attribut du solde du joueur.
		static int betuser=0;//la mise du joueur sera une valeur entiere.
		static int misechiffre;//attribut miser chiffre deviendra un tableau pour split. pour l'instant le joueur mise un seul chiffre
		static int misecouleur;//mise couleur en int j'evite les faute de frapes.
		static int misepaire;//int misepaire j'evite les faute de frappes.
		
		public static void Main(string[] args)
		{
			AttribuerCouleurs();
			Jouer();
			
			Console.ReadKey(true);
		}
		
		
		public static int VerifInt(string xxr)
		{
			int choix=0;
			int mauvais = 0;
			try
			{
				choix= Int32.Parse(xxr);
			}
			catch
			{
				mauvais=1;
			}
			    while (mauvais ==1)
			    {
			    	Console.WriteLine("Veuillez Introduire un nombre svp");
			    	xxr=Console.ReadLine();
			    	if(Int32.Parse(xxr)>=0)
			    	{
			    		choix=Int32.Parse(xxr);
			    		mauvais=0;
			    	}
			    }
			
			return choix;
		}
		
		public static void Jouer()
		{
			while(solde!=0)
			{
				Miser();
				Console.WriteLine("-----------");
				Console.WriteLine("La boule est tomber sur le : " + BouleTombe());
				CompareChiffre();
				CompareCouleur();
				ComparePaire();
				FinduJeux();
			}
		}
		
		public static void FinduJeux()
		{
			if(solde==0)
			{
				Console.WriteLine("Veuillez Rechargez votre solde");
			}
			else
			{
				Console.WriteLine("Le Prochain tour commence");
			}
		}
		
		public static void Miser()
		{
			ChoisirJeton();
			if(betuser>=5 & betuser%5==0)
			{
				DisplayMenu();
			}
			else
			{
				Console.WriteLine("nous acceptons que des billets");
				Miser();
			}
		}
		
		public static void DisplayMenu()
		{							
			bool verif1=false;
			bool verif2=false;
			bool verif3=false;
			int r=2; //variable pour le switch utile a la methode
			while(r<4 & r>0)
			{
				QueFaiteVous();
				string xxr = Console.ReadLine();
				r = VerifInt(xxr);
				switch(r)
			       	{
					case 1:
			       		{
						if(verif1==true) // si déja miser ca le sortira
						{
							MauvaisChoix();							
							break;
						}
						else
						{
			       			        Console.WriteLine("sur quel chiffre voulez vous miser?");
			       			        string xyx=Console.ReadLine();
			       			        misechiffre=VerifInt(xyx);//comme ca l'utilisateur met que des chiffres.
			       			        MajSolde();
			       			        verif1=true;
			       			        break;
						}
			       		}
					case 2:
			       		{
						if(verif2==true)//si déja miser sa le sortira
						{
							MauvaisChoix();
							break;
						}
						else
						{
							MiserCouleurConsole();
			       			       string hhh=Console.ReadLine();
			       			       misecouleur=VerifInt(hhh);
			       			       MajSolde();
			       			       verif2=true;
			       			       break;
						}
			       		}
					case 3:
			       		{
						if(verif3==true)//si il a déja miser ca lui interdira
						{
							MauvaisChoix();
							break;
						}
						else
						{
							MiserPaireConsole();
							string aaa= Console.ReadLine();
							misepaire=VerifInt(aaa);
							MajSolde();
							verif3=true;
							break;
						}
			       		}
			       }
				
				if(solde==betuser)// permet de sortir l'tulisateur du menu quand il n'a plus de solde.
				{
					Console.WriteLine("Vous n'avez plus le droits de miser");
					r=0;
				}
			}
		}
		
		public static void ChoisirJeton()
		{
			ChoisirJettonConsole();
			string xx=Console.ReadLine();
			betuser = VerifInt(xx);
			
		}
		
		public static void ComparePaire()
		{
			int bouletombe = VerifInt(tableroulette[0,truerandom]);
			if((bouletombe%2!=0) && misepaire==1)
			{
				int r=betuser*2;
				solde=solde+r;
				Console.WriteLine("Vous avez gagnez :"+r+" euros!");
			}
			
			if((bouletombe%2==0) && misepaire==0)
			{
				int r=betuser*2;
				solde=solde+r;
				Console.WriteLine("Vous avez gagnez :"+r+" euros!");
			}
		}
		
		public static void CompareCouleur()
		{
			if(tableroulette[1,truerandom]=="rouge" && misecouleur==1)
			{
				int r=betuser*2;
				solde=solde+r;
				Console.WriteLine("Vous avez gagnez :"+r+" euros!");
			}
			
			if(tableroulette[1,truerandom]=="noir" && misecouleur==2)
			{
				int r=betuser*2;
				solde=solde+r;
				Console.WriteLine("Vous avez gagnez :"+r+" euros!");
			}
		}
		
		public static void CompareChiffre()
		{
			int bouletombe = VerifInt(tableroulette[0,truerandom]);
			if(bouletombe==misechiffre)
			{
				int r=betuser*36;
				solde=solde+r;
				Console.WriteLine("Vous avez gagnez :"+r+" euros!");
			}
		}
		
		public static string BouleTombe()
		{
			truerandom = rand.Next(38);
			bouleconcat= tableroulette[0,truerandom] +" "+ tableroulette[1,truerandom];
			return bouleconcat;
		}
		
		public static void AttribuerCouleurs() 
		{
			ListerCouleurs();
			for(int i=0; i<37;i++)
			{
				if(i==0)// condition unique pour le zero qui a une couleur unique
				{
					tableroulette[0,0]="zero";
					tableroulette[1,0]="vert";
				}
				else
				{
					int r= rand.Next(couleurs.Count);
					tableroulette[0,i]=i+"";
					tableroulette[1,i]=couleurs[r];
					couleurs.RemoveAt(r);
				}
			}
		}
		
		public static void ListerCouleurs()
		{
			for(int i =0; i<18; i++)
			{
				couleurs.Add("rouge");
				couleurs.Add("noir");
			}
		}
		
		public static void QueFaiteVous()
		{
			for(int i=0; i<37;i++)
			{
				Console.Write("*");
			}
			Console.WriteLine();
			Console.WriteLine("Que faites vous? chacune des option suivante represente un jeton en mise");
			Console.WriteLine("tapez \"1\" pour miser sur un chiffre");
			Console.WriteLine("tapez \"2\" pour miser sur la couleur");
			Console.WriteLine("tapez \"3\" pour miser sur le type de nombre");
			Console.WriteLine("tapez \"5\" pour finir la mise");
			for(int i=0; i<37;i++)
			{
				Console.Write("*");
			}
			Console.WriteLine();
		}
		
		public static void ChoisirJettonConsole()
		{
			Console.WriteLine("Votre solde est de "+solde+" euros, les mises sont ouverte");
			Console.Write("quel est votre jeton de mise? seul les billet sont acceptés :");
		}
		
		public static void MauvaisChoix()
		{
			Console.WriteLine("Vous avez déja misez sur cette option,");
			Console.WriteLine("veuillez choisir une autre option ou quitter le menu de mise");			
		}
		
		public static void MiserCouleurConsole()
		{
			Console.WriteLine("sur quel couleurs voulez vous miser?");
			Console.WriteLine("-Tapez sur \"1\" pour le rouge");
			Console.WriteLine("tapez sur \"2\" pour le noir");			
		}
		
		public static void MiserPaireConsole()
		{
			Console.WriteLine("sur quel couleurs voulez vous miser?");
			Console.WriteLine("-Tapez sur \"1\" pour impaire");
			Console.WriteLine("tapez sur \"2\" pour paire");
		}
		
		public static void MajSolde()
		{
			solde =solde- betuser; //le joueur mise et perd la valeur de son solde
			Console.WriteLine("Nouveaux solde = "+solde+" euros");
		}
	}
}