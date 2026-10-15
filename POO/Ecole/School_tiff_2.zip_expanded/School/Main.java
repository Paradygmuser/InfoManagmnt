package School;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
	
        
        School s = new School("Saint-Vinde-De-Patata");
        
        s.ajouterStudent(new Student(3111, "Tiffany", "Hidki"));
        s.ajouterStudent(new Student(2002, "Ariana", "Grande"));
        s.ajouterStudent(new Student(2003, "Jin-Who", "Sung"));
        s.ajouterStudent(new Student(2010, "Cha", " Hae-In"));
        s.ajouterStudent(new Student(2005, "Christopher", "Grande"));
        s.ajouterStudent(new Student(2004, "Christopher", "Redd"));
        s.ajouterStudent(new Student(2006, "Suho", "Sung"));
         
        
        
        //s.ajouterRoom(new Room(4, 30));
        //s.ajouterRoom(new Room(1, 22));
        
        
        s.afficherEtudiantsTriesParId();
        // faire une ligne pour voire les deux methode different 
        System.out.println();
        s.afficherEtudiantsTriesParNomPrenom(); // donc lastName sont les nom de famille, il ici il y a une confusion de ma part. en tout cas le comparator trie par lastname d'abord en suite name.
        /*s.afficherLocauxsTriesParNumLoc();*/
        // maintenant si tu a compris tu devrais faire la meme chose pour les room par id et par capcité, je reveins plus tard continuer ma proposition de correction.
        //Bone soirée.
        
   
        
        
 

	}

}
