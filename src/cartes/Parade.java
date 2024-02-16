package cartes;

public class Parade extends Bataille {

	public Parade(int nombre, Type type) {
		super(nombre, type);
	}
	
	public String toString() {
		switch (getType()) {
		case FEU:
			return "Feu vert";
		case ESSENCE:
			return "Essence";
		case CREVAISON:
			return "Roue de secours";
		case ACCIDENT:
			return "Reparations";
		default:
			return "Erreur : Pas de type";
		}
	}
}