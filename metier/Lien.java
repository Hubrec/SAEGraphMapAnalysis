/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package metier;

/**
 *
 * @author mathi_tn3kay8
 */
public class Lien {
    private final String typeLien;
    private final int valuationLien;
    private final String nomLien;
    
    public Lien(String type, String nom, int valu) {
        typeLien = type;
        valuationLien = valu;
        nomLien = nom;
    }
    
    public String getLien() {
        return typeLien;
    }
    
    public int getValuation() {
        return valuationLien;
    }
    
    public String getNomLien() {
        return nomLien;
    }
    
    @Override
    public String toString() {
        return typeLien + ", " + nomLien + " - " + valuationLien;
    }
}
