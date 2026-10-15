package base;

public class Programme {

    public static void main(String[] args) {
        Loueur loueur = new Loueur();

        Voiture citroenC1 = new Voiture("123", "Citroen C1", 75);
        Voiture mercedesClasseE = new Voiture("789", "Mercredes Classe E", 150);

        Client alain = new Client("Alain");
        Client bruno = new Client("Bruno");

        loueur.demarrerLocation(new Location(alain, citroenC1));
        loueur.demarrerLocation(new Location(bruno, mercedesClasseE));

        loueur.afficherLocations();

        loueur.terminerLocation(citroenC1, 1800, 3);
        loueur.terminerLocation(mercedesClasseE, 300, 4);

        System.out.println(alain + " doit " + alain.getDette() + " €.");
        System.out.println(bruno + " doit " + bruno.getDette() + " €.");
    }
}
