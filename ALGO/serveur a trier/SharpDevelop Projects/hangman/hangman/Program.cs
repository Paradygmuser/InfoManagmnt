using System;
using System.IO;

namespace hangman
{
	class Program
	{
		public static void Main(string[] args)
		{
			HangmanAudioGame.PrepareGame();
		       HangmanAudioGame.StartGame();
		       HangmanAudioGame.Play();
			
			Console.ReadKey(true);
		}
	}
	
	class HangmanAudioGame
	{
		static string hangmanstring = File.ReadAllText("C:/Users/Enael/Documents/formation/hangman-words.game"); // liste des mots en un strng
		static string [] wordsarray = hangmanstring.Split( ); // besoin pour lire le fiche.game ranger chaque mot séparer par un espace dans un colone du array
		static Random rand = new Random();
		
		static string choosenword= "";//attribut du mot choisi en random
		static char [] devinesymbole =new char[wordsarray.Length] ; // table de charactere a comparé initialisé avec underscor
		static char [] choosenarray = new char[wordsarray.Length]; // une fois le mot choisi il sera separer en caractere dans se array
		
		static int essaies = 5 ;
		static bool att = false; // a t'il trouver une lettre?
		static bool atg=false;// a t'il gagner la partie?
		static bool dc=false; //Deja chois le caractere a til deja ete choisi durant la partie
		
		static string devinestring=""; //varaible de comparaison
		
		public  static void PrepareGame()
		{
			choosenword = wordsarray[rand.Next(wordsarray.Length)]; // normalmnt je devrai avoir un mot au hazard avec le dernier mot de la liste a verifier)
			
			for (int i=0; i<choosenword.Length ; i++)// verifier si il prend le dernier caractere ou moin un
			{
				 choosenarray[i] = choosenword[i];
				 devinesymbole[i]= '_';
			}

		}
		
		public static void StartGame()
		{
			Console.WriteLine("Hangman-Game");
			Console.Write ("hiden word : ");// test
			for (int i=0 ; i<devinesymbole.Length; i++)
			{
				Console.Write(devinesymbole[i] + " ");
			}
			Console.WriteLine();
			Console.WriteLine("you have "+essaies+" try , enter one charactere than press enter(only the first one as readed)");
		}
		
		public static void Play()
		{
			
			char charuser='0' ; //varable pour stocker le caractere de 'utilisateur
			
			while(essaies !=0 && atg == false)
			{
				Console.Write("Votre proposition : ");
			       string stringuser = Console.ReadLine();
			       
				for(int i =0 ; i<1;i++)
				{
					charuser = stringuser[i]; // pour eviter les interuption de probgram je previens que seul la premiere letre sera lu, si il se trompe les essaie en paiert les consequences.
				}
				
				for(int e=0 ; e<devinesymbole.Length; e++)
				{
					if(charuser==devinesymbole[e])
					{
						dc =true;
						att=false; // si le caractere introduit est deja dans le tableau des caractere deviné alors perte -1 essaie
					}
				}
				
				for(int a =0 ; a<choosenarray.Length ; a++)
				{
					if (charuser == choosenarray[a])
					{
						devinesymbole[a] = charuser;
						att =true;
					}
				}

				if(att==false | dc == true)
				{
					essaies =essaies - 1;
				}
				
				if(dc == true)
				{
					Console.WriteLine("Character already used, you lost a try");
				}
				
				dc=false;
				att=false;
				
				Console.Write ("Hiden word : ");
				for(int u =0 ; u<devinesymbole.Length; u++ )
				{
					devinestring += devinesymbole[u];
					Console.Write(devinesymbole[u]+" ");
				}
				if (devinestring == choosenword)
				{
					atg=true;
				}
				Console.WriteLine();
				Console.WriteLine("il vous reste "+ essaies +" essaies ");
				
				
				devinestring="";
					
			}
			
			
				
			
			if(essaies ==0)
			{
				Console.WriteLine("LOST , Restart game");
			}
			if (atg == true)
			{
				Console.WriteLine("WIN! Congratulation, you find the hidden word");
			}

			
			
		}
		
	}
}