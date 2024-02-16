package cartes;

public class Botte extends Probleme {

	public Botte(int nombre, Type type) {
		super(nombre, type);
	}
	
	public String toString() {
		switch (getType()) {
			case FEU:
				return "Vehicule prioritaire";
			case ESSENCE:
				return "Citerne d'essence";
			case CREVAISON:
				return "Increvable";
			case ACCIDENT:
				return "As du volant";
			default:
				return "Erreur : Pas de type";
		}
	}
}