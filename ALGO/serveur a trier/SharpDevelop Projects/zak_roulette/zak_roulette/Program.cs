/*
 * Created by SharpDevelop.
 * User: Admin
 * Date: 22-04-25
 * Time: 18:47
 * 
 * To change this template use Tools | Options | Coding | Edit Standard Headers.
 */
using System;
using System.Collections.Generic;
namespace roulette_zakaria
{
class Program
    {
static Random random = new Random(); // Le random doit tjr être mis ici pas dans une méthode
static string[] numeros = new string[37]; // tableau de taille 37 pour avoir de [0;36] et qui prendra des couleurs à chaque position dans le tableau
static List<string> colors = new List<string>(); // on crée un liste qui sera modifié à chaque itération par la suite(on jouera sur la taille de la liste)
static int number;
static string couleur;
static string askColor;
static string askPairImpair;
static string askMise;
static int gain1,gain2,gain3;
static int gainTotal;
static string askNumber;
static int askNumberInt;

public static void AttribuerCouleurs(){
for(int i = 0; i < 18;i++){ // on fait une boucle for avec i<18 pour avoir 18 couleurs rouge/noir
                colors.Add("rouge"); // Add permet d'ajouter rouge à la liste
                colors.Add("noir");  // Add permet d'ajouter noir à la liste
            }
            numeros[0] = "vert"; // arrtribuer la position 0 à la couleur vert (couleur fixe pour 0)
for(int i = 1; i < numeros.Length;i++){// on itère sur le tableau afin d'associer une couleur à un numéro aléatoire (on commence le for à 1 pour optimiser)
int randNumber = random.Next(0,colors.Count);// méthode random pour prendre aléatoirement une couleur
                numeros[i] = colors[randNumber];// on associe le numéro à une couleur choisie aléatoirement
                colors.RemoveAt(randNumber);// on supprime le dernier élèment choisi de la liste pour éviter la répétition
            }
        }
public static void AfficherRoulette(){
for(int i = 0; i < numeros.Length;i++){
                Console.WriteLine(i+" " + numeros[i]); // on affiche le nombre i de la boucle for associé à la couleur qui est tirée aléatoirement
            }
        }
public static string NumeroSorti(){
            number = random.Next(0,numeros.Length);
            couleur = numeros[number];
string lancer = number+"-"+couleur;
            return lancer;
        }
public static void DemanderCouleur(){
            Console.WriteLine("Quelle couleur voulez-vous jouer ? rouge / noir, si vous ne souhaitez pas miser sur la couleur entrez : x");
            askColor = Console.ReadLine();
        }
public static void DemanderPairImpair(){
            Console.WriteLine("voulez-vous jouer sur pair / impair ? entrez l'un des deux choix sinon, entrez x pour ne pas jouer cette mise");
            askPairImpair = Console.ReadLine();
        }
public static void DemanderNumero(){
            Console.WriteLine("voulez-vous jouer sur un numéro ? si oui entrer un numéro entre 0 et 36 si non entrez x");
            askNumber = Console.ReadLine();
if(askNumber!="x"){
                askNumberInt = Int32.Parse(askNumber);
            }
        }
public static void Mise(){
            Console.WriteLine("Veuillez entrer votre mise de départ");
            askMise = Console.ReadLine();
            gain1 = Int32.Parse(askMise);
            gain2 = Int32.Parse(askMise);
            gain3 = Int32.Parse(askMise);
        }
public static void Verif(){
            //CONDITIONS POUR VERIFIER LA COULEUR
if(askColor==couleur){
                gain1=gain1*2;
                Console.WriteLine("Bien joué vous avez trouvé la bonne couleur");
            }else if(askColor=="x"){
                gain3=0;
            }else{
                gain1=0;
                Console.WriteLine("Perdu la couleur du jeux était "+couleur);
            }
            //CONDITION POUR VERIFIER PAIR IMPAIR
if(number%2==0 && askPairImpair=="pair"){
                gain2=gain2*2;
                Console.WriteLine("Bien joué le lancé est pair");
            }if(number%2!=0 && askPairImpair=="impair"){
                gain2=gain2*2;
                Console.WriteLine("Bien joué le lancé est impair");
            }if(askPairImpair=="x"){
                gain3=0;
            }if(number%2==0 && askPairImpair=="impair"){
                gain2=0;
                Console.WriteLine("Perdu, vous avez misé sur impair et le numéro du jeu était pair");
            } if(number%2!=0 && askPairImpair=="pair") {
                gain2=0;
                Console.WriteLine("Perdu, vous avez misé sur impair et le numéro du jeu était pair");
            }
            //CONDITION POUR MISER SUR UN NUMERO
if(askNumber!="x"){
if(askNumberInt==number){
                    gain3=gain3*2;
                    Console.WriteLine("Bien joué vous avez trouvé le numéro de la roulette");
                }if(askNumberInt!=number){
                    gain3=0;
                    Console.WriteLine("Perdu, vous avez misé sur le mauvais numéro");
                }
            }if(askNumber=="x"){
                gain3=0;
            }
            gainTotal=gain1+gain2+gain3;
        }
public static void Main(string[] args)
        {
AttribuerCouleurs(); //appeler la méthode pour que le code s'exécute
AfficherRoulette();  //appeler la méthode pour que le code s'exécute
Mise();
DemanderCouleur();
DemanderPairImpair();
DemanderNumero();
            Console.WriteLine("Le numéro et la couleur sont : "+NumeroSorti());
Verif();
            Console.WriteLine("Vous avez gagné un total de : "+gainTotal+" ("+gain1+" pour la mise sur la couleur, "+gain2+" pour la mise sur pair/impair et "+gain3+" pour la mise sur le numéro)");
            Console.ReadKey(true);
        }
    }
}