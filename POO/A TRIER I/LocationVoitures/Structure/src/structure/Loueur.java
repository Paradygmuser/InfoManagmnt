package structure;

import java.util.LinkedList;
import java.util.List;


public class Loueur  {
    private final List<Location> locationsEnCours = new LinkedList<>();
    
    public void demarrerLocation(Location nouvelleLoc){
        for(Location location : locationsEnCours){
            if(location.getVoiture().equals(nouvelleLoc.getVoiture())){
                throw new RuntimeException("Voiture déjà louée");
            }
        }
        locationsEnCours.add(nouvelleLoc);
    }
    
    public void terminerLocation(Voiture voiture, int nombreKm, int nombreJours){
        Location loc = null;
        for(Location location : locationsEnCours){
            if(location.getVoiture().equals(voiture)){
                loc = location;
                loc.cloturer(nombreKm, nombreJours);
                break;
            }
        }
        if(loc == null) 
            throw new RuntimeException("Location inexistante");
        locationsEnCours.remove(loc);
    }
    
    public void afficherLocations(){
        System.out.println("Locations en cours : ");
        for(Location l : locationsEnCours)
            System.out.println(" - " + l);
    }
}
