package locations;

public class Programme {

    public static void main(String[] args) {
        Loueur loueur = new Loueur();
        Voiture citroenC1 = new Voiture("123", "Citroen C1", 75);
        Client alain = new Client("Alain");

        Location l1 = new Location(alain, citroenC1);
        loueur.demarrerLocation(l1);
        loueur.terminerLocation(citroenC1, 100, 3);
        System.out.println("Prix de l1 : " + l1.getPrix() + " €.");
        System.out.println(alain + " doit " + alain.getDette() + " €.");

        LocationAlpha l2 = new LocationAlpha(alain, citroenC1);
        loueur.demarrerLocation(l2);
        loueur.terminerLocation(citroenC1, 100, 3);
        System.out.println("Prix de l2 : " + l2.getPrix() + " €.");
        System.out.println(alain + " doit " + alain.getDette() + " €.");

        LocationBeta l3 = new LocationBeta(alain, citroenC1);
        loueur.demarrerLocation(l3);
        loueur.terminerLocation(citroenC1, 100, 3);
        System.out.println("Prix de l3 : " + l3.getPrix() + " €.");
        System.out.println(alain + " doit " + alain.getDette() + " €.");
    }
}
