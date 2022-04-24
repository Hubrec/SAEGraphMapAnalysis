package metier;

public class Monument extends Ville{
	private String nomMonument;

	
	public Monument(String nomV, String nomM) {
		super(nomV);
		nomMonument = nomM;
	}
	
	public String getNomMonument() {
		return nomMonument;
	}

	public void setNomMonument(String nom) {
		nomMonument = nom;
	}

	@Override
	public String toString() {
		return("\n -- TYPE MONUMENT -- \n" + super.toString() + 
				"\n   nom du monument : " + nomMonument);
	}

}
