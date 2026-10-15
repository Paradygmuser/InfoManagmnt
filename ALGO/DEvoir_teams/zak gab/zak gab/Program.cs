using System;
 
namespace TestTryCatch
{
	class Program
	{
		static int convert =0;
		static string inputUser;
		public static void Main(string[] args)
		{
			Console.WriteLine("Quel montant voulez-vous retirer ?");
			AskUser();
			Max500();
			Arrondir();
			Distrib();
			// montant max 500 si + ramener a 500
			// arrondir le montant au plus grand nombre suivant divisible par 5
			// le distrib donne le montant en gros billet
			Console.ReadKey(true);
		}
		public static void AskUser()  {
			inputUser = Console.ReadLine();
		}
		public static void Max500() {
			try{
			convert = Int32.Parse(inputUser);
			}catch(Exception ex) {
				Console.WriteLine("Erreur, entrez un montant valide !");
				inputUser=Console.ReadLine();
			}
			if(convert>500){
				convert=500;
			}
		}
		public static void Arrondir() {
			if(convert%5==0) {
				Console.WriteLine("votre montant est bon");
			}else{
				Console.WriteLine("votre montant n'est pas possible il sera arrondi");
				do {
					convert=convert+1;
					Console.WriteLine(convert);
				}while(convert%5!=0);
			}
		}
		public static void Distrib() {
			int billet50 = convert/50;
			int rest50 = convert%50;
			int billet20 = rest50/20;
			int rest20 = rest50%20;
			int billet10 = rest20/10;
			int rest10 = rest20%10;
			int billet5 = rest10/5;
			int rest5 = rest10%5;
			Console.WriteLine("Vous allez recevoir "+billet50+" billets de 50, "+billet20+" billets de 20, "+billet10+" billets de 10, "+billet5+" et billets de 5");

 
		}
	}
}// See https://aka.ms/new-console-template for more information