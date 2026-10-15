// See https://aka.ms/new-console-template for more information
using System;
using Battaille_Exam;



    CardGames cardGames = new CardGames();
    cardGames.CreerJeuxDeCarte();
    List<string> paquetmelanger = cardGames.Melanger();
    cardGames.DistribuerCarte();
    cardGames.SimulerPartie();
    Console.ReadKey(true);


