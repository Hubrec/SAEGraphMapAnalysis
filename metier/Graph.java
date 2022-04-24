/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

import java.util.ArrayList;

/**
 *
 * @author mathi_tn3kay8
 */
public class Graph {
    private ArrayList<Ville> liste;
    
    public Graph() {
        liste = new ArrayList<Ville>();
    }
        
    public void toutCacher() {
        for(Ville v : liste) {
            v.setVisibilite(false);
        }
    }
    
    public void toutMontrer() {
        for(Ville v : liste) {
            v.setVisibilite(true);
        }
    }
    
    public void ajouter(Ville v) {
        liste.add(v);
    }
    
    public Ville get(int indice) {
        return liste.get(indice);
    }
    
    public int getIndice(Ville v) {
        for(int i=0; i<liste.size();i++) {
            if(v.getNomVille().equals(liste.get(i).getNomVille())) {
                return i;
            }
        }
        return -1;
    }
    
    public ArrayList<Ville> getListe() {
        return liste;
    }
    
    public int getValuation(Ville ville1, Ville ville2) {
        return ville1.getValuation(ville2);
    }
    
    public void afficher() {
        for(Ville v : liste) {
            v.afficher();
            System.out.println();
        }
    }
    
    public int calculerNbrRestaurants() {
        int cpt = 0;
        for(Ville v : liste) {
            if (v.getClass().getName() == "metier.Restaurant" && v.getVisibilite()) {
                cpt ++;
            }
        }
        return cpt;
    }
    
    public int calculerNbrMonument() {
        int cpt = 0;
        for(Ville v : liste) {
            if (v.getClass().getName() == "metier.Monument" && v.getVisibilite()) {
                cpt ++;
            }
        }
        return cpt;
    }
    
    public int calculerNbrMusee() {
        int cpt = 0;
        for(Ville v : liste) {
            if (v.getClass().getName() == "metier.Musee" && v.getVisibilite()) {
                cpt ++;
            }
        }
        return cpt;
    }
    
}
