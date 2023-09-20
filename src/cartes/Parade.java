package cartes;

public class Parade extends Bataille {

	public Parade(Type t, int n) {
		super(t, n);
	}
	
	public String toString() {
		switch (type) {
		case FEU:
			return "FeuVert";
		case ESSENCE:
			return "Essence";
		case CREVAISON:
			return "RoueDeSecours";
		case ACCIDENT:
			return "Reparations";
		default:
			return "";
		}
	}
}
