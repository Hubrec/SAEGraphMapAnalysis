package metier;

public class Musee extends Ville{
	private String nomMusee;
	
	public Musee(String nomV, String nomM) {
		super(nomV);
		nomMusee = nomM;
	}
	
	public void setNomMusee(String nom) {
		nomMusee = nom;
	}

	public String getNomMusee() {
		return nomMusee;
	}

	@Override
	public String toString() {
		return("\n -- TYPE MUSEE -- \n" + super.toString() +
				"\n   le nom du musee : " + nomMusee);
	}
}
