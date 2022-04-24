package metier;

public class Restaurant extends Ville{
	private String nomRestaurant;
	
	public Restaurant(String nomV, String nomR) {
		super(nomV);
		nomRestaurant = nomR;
        }
	
	public void setNomRestaurant(String nom) {
		nomRestaurant = nom;
	}

	public String getNomrestaurant() {
		return nomRestaurant;
	}

	@Override
	public String toString() {
		return("\n -- TYPE RESTAURANT -- \n" + super.toString() +
				"\n   nom du restaurant : " + nomRestaurant );
	}	
}
