package cartes;

public class Botte extends Probleme {

	public Botte(Type t, int n) {
		super(t,n);
	}
	
	public String toString() {
		switch (type) {
		case FEU:
			return "VehiculePrioritaire";
		case ESSENCE:
			return "CiterneEssence";
		case CREVAISON:
			return "Increvable";
		case ACCIDENT:
			return "AsDuVolant";
		default:
			return "";
		}
	}
}
