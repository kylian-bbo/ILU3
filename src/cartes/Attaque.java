package cartes;

public class Attaque extends Bataille {

	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}
	
	public String toString() {
		switch (getType()) {
		case FEU:
			return "Feu rouge";
		case ESSENCE:
			return "Panne d'essence";
		case CREVAISON:
			return "Crevaison";
		case ACCIDENT:
			return "Accident";
		default:
			return "Erreur : Pas de type";
		}
	}
}