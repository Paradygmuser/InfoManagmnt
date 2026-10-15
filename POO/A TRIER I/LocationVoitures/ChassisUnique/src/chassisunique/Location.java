package chassisunique;

public class Location {
    private final Client client;
    private final Voiture voiture;
    private int nombreKm;
    private int nombreJours;
    
    public Location(Client client, Voiture voiture){
        this.client = client;
        this.voiture = voiture;
    }
    
    @Override
    public String toString(){
        return voiture + " louée à " + client;
    }
    
    public double getPrix(){
        return nombreJours * voiture.getPrixParJour();
    }

    public Client getClient() {
        return client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    void cloturer(int nombreKm, int nombreJours) {
        this.setNombreKm(nombreKm);
        this.setNombreJours(nombreJours);
        client.ajouterDette(getPrix());
        voiture.ajouterKm(nombreKm);
    }

    public int getNombreKm() {
        return nombreKm;
    }

    private void setNombreKm(int nombreKm) {
        this.nombreKm = nombreKm;
    }

    public int getNombreJours() {
        return nombreJours;
    }

    private void setNombreJours(int nombreJours) {
        this.nombreJours = nombreJours;
    }
}
