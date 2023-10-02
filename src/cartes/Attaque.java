package cartes;

public class Attaque extends Bataille {

	public Attaque(Type t, int n) {
		super(t, n);
	}
	
	public String toString() {
		switch (type) {
		case FEU:
			return "Feu Rouge";
		case ESSENCE:
			return "Panne Essence";
		case CREVAISON:
			return "Crevaison";
		case ACCIDENT:
			return "Accident";
		default:
			return "";
		}
	}
}
