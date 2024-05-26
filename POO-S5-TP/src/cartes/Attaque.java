package cartes;

import jeu.Joueur;

public class Attaque extends Bataille {
	
	static {
		stringType.put(Type.FEU, "Feu Rouge");
		stringType.put(Type.ESSENCE, "Panne Essence");
		stringType.put(Type.CREVAISON, "Crevaison");
		stringType.put(Type.ACCIDENT, "Accident");
	}
	
	public Attaque(Type t, int n) {
		super(t, n);
	}

	@Override
	public boolean appliquer(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}
}
