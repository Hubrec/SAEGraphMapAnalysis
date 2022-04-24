package metier;

import java.util.ArrayList;

public abstract class Ville {
	private final int numVille;
	private String nomVille;
	private static int dernierNumeroVille = 1;
        private ArrayList<Ville> voisins;
        private ArrayList<Lien> liens;
        private int cordX;
        private int cordY;
        private boolean visible;
	
	public Ville(String nom) {
            numVille = getDernierNumeroVille();
            nomVille = nom;
            voisins = new ArrayList<Ville>();
            liens = new ArrayList<Lien>();
            visible = true;
	}
        
        public void setVisibilite(boolean v) {
            visible = v;
        }
        
        public boolean getVisibilite() {
            return visible;
        }
	
	public static int getDernierNumeroVille() {
            return dernierNumeroVille++;
	}
        
        public void setCordX(int X) {
            cordX = X;
        }
        
        public void setCordY(int Y) {
            cordY = Y;
        }
        
        public int getCordX() {
            return cordX;
        }
        
        public int getCordY() {
            return cordY;
        }
	
	public int getNumVille() {
            return numVille;
	}
	
	public String getNomVille() {
            return nomVille;
	}
        
	public void setNomVille(String nomV) {
            nomVille = nomV;
	}
        
        public void ajouterVoisin(Ville v, Lien l) {
            voisins.add(v);
            liens.add(l);
        }
        
        public int getValuation(Ville v) {
            for(int i=0; i<voisins.size(); i++) {
                if(v == voisins.get(i)) {
                    return liens.get(i).getValuation();
                }
            }
            return -1;
        }
        
        public String getTypeLien(Ville v) {
            for(int i=0; i<voisins.size(); i++) {
                if(v == voisins.get(i)) {
                    return liens.get(i).getLien();
                }
            }
            return "err";
        }
        
        public ArrayList<Ville> getVoisins() {
            return voisins;
        }
        
        public ArrayList<Lien> getLiens() {
            return liens;
        }
        
        public void afficher() {
            System.out.print(getNomVille() + " : ");
            for(int i=0; i<voisins.size();i++) {
                System.out.print(liens.get(i).getValuation() + "-");
                System.out.print(voisins.get(i).nomVille+" ");
            }
            System.out.println();
        }

	@Override
	public String toString() {
		return( "\n   numero de la ville : " + numVille +
			"\n   nom de la ville : " + nomVille);
	}
}