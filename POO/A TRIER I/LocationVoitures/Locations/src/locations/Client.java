package locations;

public class Client {
    private final String nom;
    private double dette;
    
    public Client(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public double getDette() {
        return dette;
    }
    
    public void ajouterDette(double dette){
        this.dette += dette;
    }
    
    @Override
    public String toString(){
        return nom;
    }
}
