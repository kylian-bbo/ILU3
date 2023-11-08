package cartes;

import jeu.Joueur;

public class Botte extends Probleme {

	public Botte(Type t, int n) {
		super(t,n);
	}
	
	public String toString() {
		switch(type) {
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

	@Override
	public boolean appliquer(Joueur j) {
		j.getBottes().add(this);
		
		int indiceDerniereBataille = j.getBatailles().size() - 1;
		
		if (indiceDerniereBataille > -1) {
			Bataille bataille = j.getBatailles().get(indiceDerniereBataille);
		
			if (bataille instanceof Attaque && bataille.type == this.type)
				j.getBatailles().remove(indiceDerniereBataille);
		}
		return true;
	}
}
