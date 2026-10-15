using System.ComponentModel.DataAnnotations;
using System.Runtime.CompilerServices;
using System.Runtime.ExceptionServices;

namespace Battaille_Exam;

public class CardGames
{
    Random rand = new Random();
    private string[] colors = { "♣️", "❤️", "♦️", "♠️" };
    private string[] valeurs = new string [13];
    public List<string> joueur1 = new List<string>();
    public List<string> joueur2 = new List<string>();
    
    public void AjouterNombres()
    {
        for (int i=0; i<valeurs.Length; i++)
        {
            if (i==10)
            {
                valeurs[i] = "J";
            }
            else if (i==11)
            {
                valeurs[i] = "Q";
            }
            else if (i==12)
            {
                valeurs[i] = "K";            
            }
            else
            {
                valeurs[i] = (i+1)+"";
            }
        }
        
    }

    public string[] CreerJeuxDeCarte()
    {
        AjouterNombres();
        string [] paquet = new string [52];//je n'ai pas compté les joker.
        for (int i = 0; i < colors.Length; i++)
        {
            for (int j = 0; j < valeurs.Length; j++)
            {
                paquet[i] = valeurs[j]+"-"+colors[i];
            }
        }
        return paquet;
    }

    public void AfficherCartes()
    {
        string [] paquet = CreerJeuxDeCarte();
        for (int i = 0; i < paquet.Length; i++)
        {
            Console.WriteLine(paquet[i]); // j'ai prefere mettre ca dans un tableau comme ca le random ce fait sur un tableau fixe qui bouge pas/
        }
    }

    public List<string> Melanger()
    {
        string [] paquet = CreerJeuxDeCarte();
        List<string> paquetmelanger = new List<string>();

        for (int i = 0; i < 52; i++)
        {
            int r=rand.Next(52);
            paquetmelanger.Add(paquet[r]);
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
        else
        {
            result=int.Parse(values[0]);
        }
        
        return result ;
    }

    public int ComparerCartes(string valeur1, string valeur2)
    {
        int result = 33;
        if ((GetValeur(valeur1)) > GetValeur(valeur2))
        {
            result = 0;
        }
        else if ((GetValeur(valeur1)) < GetValeur(valeur2))
        {
            result = 1;
        }
        else if ((GetValeur(valeur1)) == GetValeur(valeur2))
        {
            result = 2;
        }

        return result;
    }

    public void DistribuerCarte()
    {
        List<string> paquetdejeux = Melanger();
        int a = 0;//j'uilise cette variable pour ditribuer les cartes au joueur 1
        int b = 1;// j'utilise cette variable pour distribuer les carte au joueur 2
        
        for (int i=0; i<paquetdejeux.Count;i++)
        {
            joueur1.Add(paquetdejeux[a]); //ajoute la carte a l'indice a de la liste ("valeur-couleur")
            joueur2.Add(paquetdejeux[b]); // ajoute la carte a l'indice B de la liste
            paquetdejeux.RemoveAt(a);
            paquetdejeux.RemoveAt(b);
            a += 2;//apres les instruction ci dessu tu rajoute +2 on passera de 0 à 2 pour le joueur 1
            b += 2;/*
                   /
                   /apres les instructions ci dessus tu rajoute deux on passera de 1 à 3,
                   / l'idée est de donnée une carte a chaque joueur, chacun a son tour.
                   /
                   */
        }
    }

    public void SimulerPartie()
    {
        DistribuerCarte();
        string cartejoueur1 = ""; //j'aurais besoin de sauvegarder la carte pour le bon déroulement de la partie
        string cartejoueur2 = "";
        int wxc = 0;// compte le nombre d'égalité et est utile pour la suite. il sera utilisé que dans l'égalité 
        int sccoorre = ComparerCartes(cartejoueur1,cartejoueur2);
        
        /*///////////////////////////////////////////////////////*/
        Console.WriteLine("Bataille!");
        while (((joueur1.Count) !=0) | ((joueur2.Count) !=0))
        {
            cartejoueur1 = joueur1[0];
            cartejoueur2 = joueur2[0];
            List<string> egaliteList = new List<string>();
            
            joueur1.RemoveAt(0);//retire la carte déposé du paquet1 ON RETIRE DIRECTEMENT EN DEBUT DE TOUR
            joueur2.RemoveAt(0);//retire la carte déposé du paquet 2
            Console.WriteLine("Appuyer sur une touche pour le prochaine tour");
            Console.ReadLine();
            Console.WriteLine("Le joueur 1 dépose :"+ cartejoueur1); // chaque joueur affiche la premiere carte de sa liste
            Console.WriteLine("Le joueur 2 dépose :"+ cartejoueur2);//mais en vrai c'est juste pour une interaction console on est pas obligé de faire ca

            if (sccoorre==0)
            {
                joueur1.Add(cartejoueur2);//ajoute la carte du joueur 2 a la fin de la list
                joueur1.Add(cartejoueur1);// reprend la carte a la fin de la liste
                Console.WriteLine("Le joueur 1 gagne");
            }
            else if (sccoorre==1)
            {
                joueur2.Add(cartejoueur2);//ajoute la carte du joueur 2 a la fin de la list
                joueur2.Add(cartejoueur1);// reprend la carte a la fin de la liste
                Console.WriteLine("le joueur 2 gagne");
            }

            while (sccoorre ==2)
            {
                Console.WriteLine("Egalité");
                bool findelegalite = false;
                
                egaliteList.Add(joueur1[wxc]); // l'ordre a une tres grand importance ici pour la suite du code,car je suppose que la dernier carte déposé sera comparer. donc le joueur1 et 2 on une place dans la liste.
                egaliteList.Add(joueur2[wxc]);
                egaliteList.Add(joueur1[wxc + 1]);
                egaliteList.Add(joueur2[wxc + 1]); //vu que chaque joueur dépose 2 carte il y a 4 carte sur table enplus de cartejoueur1 et 2 qui ont déja été retirer de la liste de chaque joueur en début de partie.
              //tant qu'il y a l'égalité.
                sccoorre = ComparerCartes(egaliteList[egaliteList.Count-1],egaliteList[egaliteList.Count]);//recompare tant que l'égalité existe le dernier et l'avant dernier de la list egaliter..
                
                    
                if (sccoorre==0)
                {
                    Console.WriteLine("le joueur 1 l'emporte");
                    for (int i = 0; i < egaliteList.Count; i++)
                    {
                        joueur1.Add(egaliteList[i]); // si le joueur un gagne rajoute lui la list egaliter
                    }
                    findelegalite = true;
                }
                else if (sccoorre == 1)
                {
                    Console.WriteLine("le joueur 2 l'emporte");
                    for (int i = 0; i < egaliteList.Count; i++)
                    {
                        joueur2.Add(egaliteList[i]); // si le joueur deux gagne rajoute lui la list egaliter
                    }
                    findelegalite = true;
                }

                else if (sccoorre==2) 
                {
                    wxc+=2;// //l'index ittére par 2, car si premiere égalité il est initailisé a 1 ,car apres une premiere egalité chaque joueur a deja mis en jeux 1 carte chacun, le tour suivant c'est 3 etc.
                }
                
                else if (findelegalite == true)// si fin d'égalité on va retiré les carte du début de la liste au deux joueur, vu que le gagnant aura ganger les carte en fin de liste..
                {
                    for (int i = 0; i < egaliteList.Count; i++)
                    {
                        joueur1.RemoveAt(i);
                        joueur2.RemoveAt(i);
                        //si l'égalité se termine retire moi les carte utilisé depuis l'indice 0 a savoir que les premiere carte on été retiré avant la premiere égalité. donc dans la boucle si il y a eu 2 égélaité il retirera celle qui sont apparu durant l'égalité.
                    }
                    egaliteList.Clear();// si fin d'égalité apres la boucle clear la list
                }                
            }
            
            
        }
        Console.WriteLine("il reste : "+joueur1.Count+" au joueur 1"+joueur2.Count+" au joueur 2");        
    }
}