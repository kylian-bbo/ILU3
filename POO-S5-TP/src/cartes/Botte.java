package cartes;

import jeu.Joueur;

public class Botte extends Probleme {
	
	static {
		stringType.put(Type.FEU, "Vehicule Prioritaire");
		stringType.put(Type.ESSENCE, "Citerne Essence");
		stringType.put(Type.CREVAISON, "Increvable");
		stringType.put(Type.ACCIDENT, "As Du Volant");
	}
	
	public Botte(Type t, int n) {
		super(t, n);
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
