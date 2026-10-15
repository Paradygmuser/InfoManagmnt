package chassisunique;

public class Programme {

    public static void main(String[] args) {
        Voiture citroenC1 = new Voiture("123", "Citroen C1", 75);
        System.out.println("OK");
        Voiture mercedesClasseE = new Voiture("789", "Mercredes Classe E", 150);
        System.out.println("OK");
        Voiture simca1000 = new Voiture("789", "Simca 1000", 5); //exception ! 
        System.out.println("OK"); 
    }
}
