using System;
using System.Collections.Generic;
using System.IO;

namespace examprepa4
{
	
	public class reservation
	{
		Random rand = new Random();
		List<string> sieges = new List<string>(); // liste initial qui m'a aider a demarrer le code probablement que je garderais qu'un seul tableau
		string [] sieges_reserver = new string [40]; //40 colonnes pour les siege reserver les valeur seront ecraser par nomsieges+"*"
		string [] nomsieges = {"A","B","C","D"};
		string reservationclient="";
		
		public void Rangees()
		{
			string nomcomplet = "";
			for(int i = 1; i<11; i++ ) //10 fois fais 4 fois le nom assigné a  la rangé en liste. 
			{
				for(int y = 0; y<nomsieges.Length;y++)
				{
					nomcomplet = i+nomsieges[y];
					sieges.Add(nomcomplet);
				}				
			}
			for(int i = 0 ; i<sieges.Count;i++)
			{
				sieges_reserver[i]=sieges[i]; // je normalise dans un tableau pour ecrasé les valeur des sieges qui seront enregistré.
			}
		}
		
		public void ReservationSponsor()
		{
			for (int e=0;e<17;e++) //17 reservation precisez dans l'ennoncé
			{
				int randint= rand.Next(sieges.Count);//choisi entre 0 et 39 incul  39 est le dernier indice de la liste et 0 le premier
				sieges_reserver[randint]=(sieges_reserver[randint]+"*");
				sieges.RemoveAt(randint);
			}
		}
		
		public void AfficherSieges()
		{
			Rangees();
			ReservationSponsor();
			for(int i =0;i<sieges_reserver.Length;i++)
			{
				Console.Write(sieges_reserver[i]+" ");
				if(((i+1)%4)==0) // i+borne inferieur du modulo peremttra d'afficer 4 par 4.
				{
					Console.WriteLine();
				}
			}
		}
		
		public void ReservationClient()
		{
			MessageConsole(0);
			AfficherSieges();
			MessageConsole(1);
			string choix = Console.ReadLine();
			if (choix[0]=='x')
			{
				string [] choixarray = choix.Split('x');
				int choixint = Int32.Parse(choixarray[0]);
				reservationclient = ReservationAleatoire(choixint);
			}
			else
			{
				string [] choixarray = choix.Split(',');
				reservationclient = ReservationClient(choixarray);				
			}
		}
		
		public void SimulationReservation()
		{
			sieges_reserver = new string[40];
			MessageConsole(5);
			string clientstring= Console.ReadLine();
			
			ReservationClient();
			
			Console.WriteLine(MessageConsole(4)+reservationclient);
			
			string path = @"c:\temp\"+clientstring+".reserv";
			if (!File.Exists(path))
			{// Create a file to write to.
				using (StreamWriter sw = File.CreateText(path))
				{
					sw.WriteLine(MessageConsole(4)+reservationclient);
					
				}
			}
		}
		
		public string ReservationClient(string [] liste_choix)
		{
			string reserv_concat="";
			for(int i=0; i<liste_choix.Length;i++)
			{
				for(int a=0;a<sieges_reserver.Length;a++)
				{
					if(sieges_reserver[a]==liste_choix[i])
					{
						sieges_reserver[a]=liste_choix[i]+"*";
						reserv_concat=reserv_concat+sieges_reserver[a];
					}
				}				
			}
			
			return reserv_concat;			
		}
		
		public string ReservationAleatoire(int nbre_siege)
		{
			string concat_reserv = "";
			for(int i=0; i<nbre_siege;i++)
			{
				int randint = rand.Next(sieges_reserver.Length);
				sieges_reserver[randint] = sieges_reserver[randint]+"*";
				concat_reserv=concat_reserv+sieges_reserver[randint];				
			}			
			return concat_reserv;
		}
		
		public string MessageConsole(int choix)
		{
			string message="";
			if (choix==0)
			{
				message ="Voici les sieges disponible :";
			}
			
			else if (choix==1)
			{
				message ="voulez vous choisir vos sieges? \n tapez X suivit du nombre de siege pour que nous vous atribueons une place par notre systeme \nexemple: X4 le systeme vous atribuera 4 place aleatoirement \n sinon ecrivez votre choix(si plusieurs sieges séparer les nom d'une virgule, ex : 9A,9B,8A) :";
			}
			
			else if (choix==3)
			{
				message ="ce(s) siège(s) est(sont) déja reservé";
			}
			
			else if(choix==4)
			{
				Console.WriteLine("la reservation est confirmer vous avez le(s) siege(s) suivant :");
			}
			
			else if (choix==5)
			{
				Console.WriteLine("Pour reserver, veuillez introduire votre prenom svp :");
			}
			
			return message;
			
		}
	}
}
