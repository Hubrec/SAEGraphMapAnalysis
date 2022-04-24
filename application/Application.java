/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import metier.*;

/**
 *
 * @author mathi_tn3kay8
 */
public class Application {
    
    public static Graph gr = new Graph();
    
    public static void ouvertureFile(File fichier) throws FileNotFoundException {
        Scanner scf = new Scanner(fichier);
        
        while (scf.hasNextLine()) {
            String buffer = scf.nextLine();
            traitementLignePremierElem(buffer);
        }
        
        Scanner scfBis = new Scanner(fichier);
        
        while (scfBis.hasNextLine()) {
            String buffer = scfBis.nextLine();
            traitementVoisins(buffer);
        }
    }
    
    public static void traitementLignePremierElem(String ligne) {
        
        String sepVirgule = ",";
        String sepPointVirgule = ";";
        String sepSlash = "/";

        String separation1[] = ligne.split(sepPointVirgule);
        String separation2[] = separation1[0].split(sepVirgule);
        String separation3[] = separation2[1].split(sepSlash);
        
        switch (separation2[0]) {
            case "U" -> {
                Musee buff = new Musee(separation3[0],separation3[1]);
                gr.ajouter(buff);
            }
            case "M" -> {
                Monument buff = new Monument(separation3[0],separation3[1]);
                gr.ajouter(buff);
            }
            case "E" -> {
                Restaurant buff = new Restaurant(separation3[0],separation3[1]);
                gr.ajouter(buff);
            }
            default -> System.err.println("Erreur premier charactere");
        }
    }
    
    public static void traitementVoisins(String ligne) {

        String sepVirgule = ",";
        String sepPointVirgule = ";";
        String sepDeuxPoints = "::";
        String sepSlash = "/";

        String separation1[] = ligne.split(sepPointVirgule);
        String separation2[] = separation1[0].split(sepVirgule);
        String separation3[] = separation2[1].split(sepSlash);
        
        switch (separation2[0]) {
            case "U" -> {
                Musee buff = new Musee(separation3[0],separation3[1]);
                int indice = gr.getIndice(buff);
                
                for(int i=1; i<separation1.length;i++) {
                    String[] separationLink = separation1[i].split(sepDeuxPoints);
                    String[] sepLien = separationLink[0].split(sepVirgule);
                    String[] sepVille = separationLink[1].split(sepVirgule);
                    String[] sepVille2 = sepVille[1].split(sepSlash);
                    
                    String typeLien = sepLien[0];
                    String nomLien = sepLien[1];
                    String typeVille = sepVille[0];
                    String nomVille = sepVille2[0];
                    String nomElementVille = sepVille2[1];
                    
                    switch (typeVille) {
                        case "U" -> {
                            Musee buff2 = new Musee(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        case "M" -> {
                            Monument buff2 = new Monument(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        case "E" -> {
                            Restaurant buff2 = new Restaurant(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        default -> System.err.println("Erreur creation voisin");
                    }
                }
            }
            case "M" -> {
                Monument buff = new Monument(separation3[0],separation3[1]);
                int indice = gr.getIndice(buff);
                
                for(int i=1; i<separation1.length;i++) {
                    String[] separationLink = separation1[i].split(sepDeuxPoints);
                    String[] sepLien = separationLink[0].split(sepVirgule);
                    String[] sepVille = separationLink[1].split(sepVirgule);
                    String[] sepVille2 = sepVille[1].split(sepSlash);
                    
                    String typeLien = sepLien[0];
                    String nomLien = sepLien[1];
                    String typeVille = sepVille[0];
                    String nomVille = sepVille2[0];
                    String nomElementVille = sepVille2[1];
                    
                    switch (typeVille) {
                        case "U" -> {
                            Musee buff2 = new Musee(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        case "M" -> {
                            Monument buff2 = new Monument(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        case "E" -> {
                            Restaurant buff2 = new Restaurant(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        default -> System.err.println("Erreur creation voisin");
                    }
                }
            }
            case "E" -> {
                Restaurant buff = new Restaurant(separation3[0],separation3[1]);
                int indice = gr.getIndice(buff);
                
                for(int i=1; i<separation1.length;i++) {
                    String[] separationLink = separation1[i].split(sepDeuxPoints);
                    String[] sepLien = separationLink[0].split(sepVirgule);
                    String[] sepVille = separationLink[1].split(sepVirgule);
                    String[] sepVille2 = sepVille[1].split(sepSlash);
                    
                    String typeLien = sepLien[0];
                    String nomLien = sepLien[1];
                    String typeVille = sepVille[0];
                    String nomVille = sepVille2[0];
                    String nomElementVille = sepVille2[1];
                    
                    switch (typeVille) {
                        case "U" -> {
                            Musee buff2 = new Musee(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        case "M" -> {
                            Monument buff2 = new Monument(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        case "E" -> {
                            Restaurant buff2 = new Restaurant(nomVille, nomElementVille);
                            Lien l = new Lien(typeLien, nomLien, 10);
                            gr.get(indice).ajouterVoisin(buff2, l);
                        }
                        default -> System.err.println("Erreur creation voisin");
                    }
                }
            }
            default -> System.err.println("Erreur pour attribuer les voisins");
        }
    }
    
    public static int compterLignes(File nom) throws FileNotFoundException {
        
        Scanner scf = new Scanner(nom);
        int count = 0;

        while (scf.hasNextLine()) {
            scf.nextLine();
            count ++;
        }
        
        return count;
    }
    
    public static ArrayList<Lien> calculerPCCH(Ville v1, Ville v2) {
        
        ArrayList<Lien> liste = null;
        
        //algo de clacul de plus cours chemin
        
        
        return liste;
    }
}
