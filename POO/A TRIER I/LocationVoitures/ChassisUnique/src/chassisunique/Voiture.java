package chassisunique;

public class Voiture {

    private final String numeroChassis;
    private final String modele;
    private final double prixParJour;
    private int nombreKm;

    public Voiture(String numeroChassis, String modele, double prixParJour) {
        this.numeroChassis = numeroChassis;
        this.modele = modele;
        this.prixParJour = prixParJour;
    }

    public String getNumeroChassis() {
        return numeroChassis;
    }

    public String getModele() {
        return modele;
    }

    public double getPrixParJour() {
        return prixParJour;
    }

    public int getNombreKm() {
        return nombreKm;
    }
     
    public void ajouterKm(int km){
        nombreKm += km;
    }

    @Override
    public String toString(){
        return modele+" ("+numeroChassis+")";
    }
}
