package cartes;

public class Botte extends Probleme {

	public Botte(Type t, int n) {
		super(t,n);
	}
	
	public String toString() {
		switch (type) {
		case FEU:
			return "Vehicule Prioritaire";
		case ESSENCE:
			return "Citerne Essence";
		case CREVAISON:
			return "Increvable";
		case ACCIDENT:
			return "As Du Volant";
		default:
			return "";
		}
	}
}
