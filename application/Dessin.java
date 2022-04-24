/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import metier.*;

/**
 *
 * @author mathi_tn3kay8
 */
public class Dessin {
    public static int taille = 50;
    
    public static void dessinerGraph(JPanel j, ArrayList<Ville> liste , Graph gr) {
        Graphics2D g = (Graphics2D) j.getGraphics();
        
        int hauteur = j.getHeight();
        int largeur = j.getWidth();
        
        dessinerSommets(g, hauteur, largeur, liste);
        
        dessinerArretes(g, hauteur, largeur, liste, gr);
    }
    
    public static void dessinerSommets(Graphics2D g, int hauteur, int largeur, ArrayList<Ville> liste ) {
        for (Ville v : liste) {
            
            if (v.getVisibilite()) {
                switch (v.getClass().getName()) {
                    case "metier.Restaurant" -> g.setPaint(new Color(0,255,0));
                    case "metier.Monument" -> g.setPaint(new Color(0,0,255));
                    default -> g.setPaint(new Color(255,0,0));
                }
                
                int cordX = (int) (Math.random() * largeur);
                int cordY = (int) (Math.random() * hauteur);

                if (cordX < taille) {
                    cordX = taille;
                }
                else if(cordX > largeur - taille) {
                    cordX = largeur - taille;
                }

                if (cordY < taille) {
                    cordY = taille;
                }
                else if (cordY > hauteur - taille) {
                    cordY = hauteur - taille;
                }

                v.setCordX(cordX + taille/2);
                v.setCordY(cordY + taille/2);

                g.fillOval( cordX , cordY , taille, taille);
                g.setPaint(new Color(0,0,0));
                g.drawOval(cordX, cordY, taille, taille);
                g.drawString(v.getNomVille(), cordX, cordY);
            }
            
            
        }
    }
    
    public static void dessinerArretes(Graphics2D g, int hauteur, int largeur, ArrayList<Ville> liste , Graph gr) {
        for (Ville v1 : liste) {
            if (v1.getVisibilite()) {
                int iterator = 0;
            
                for (Ville v2 : v1.getVoisins()) {
                    boolean etSi = false;
                    
                    for (Ville vv : liste) {
                        if (vv.getNomVille().equals(v2.getNomVille())) {
                            etSi = gr.get(gr.getIndice(vv)).getVisibilite();
                        }
                    }
                    
                    if (etSi) {
                        int buff = gr.getIndice(v2);
                        if (buff >= 0) {
                            Ville v2Prim = liste.get(buff);

                            ArrayList<Lien> listeLiens = v1.getLiens();
                            Lien l = listeLiens.get(iterator);

                            switch ( l.getLien() ) {
                                case "R" -> g.setPaint(new Color(255,127,0));
                                case "A" -> g.setPaint(new Color(0,0,0));
                                default -> g.setPaint(new Color(127,0,255));
                            }

                            g.drawLine(v1.getCordX(), v1.getCordY(), v2Prim.getCordX(), v2Prim.getCordY());

                            int milX = (v1.getCordX() + v2Prim.getCordX()) / 2;
                            int milY = (v1.getCordY() + v2Prim.getCordY()) / 2;
                            g.drawString(l.toString(), milX, milY);
                            iterator ++;
                        }
                    }
                }
            }
            
        }
    }
    
    public static void clear(JPanel j) {
        Graphics2D g = (Graphics2D) j.getGraphics();
        
        int hauteur = j.getHeight();
        int largeur = j.getWidth();
        
        g.setPaint(new Color(230,230,230));
        g.fillRect(0, 0, largeur, hauteur);
    }
    
    public static void setTailleSommets(int t) {
        taille = t;
    }
}
