package cartes;

import jeu.Joueur;

public class Parade extends Bataille {
	
	static {
		stringType.put(Type.FEU, "Feu Vert");
		stringType.put(Type.ESSENCE, "Essence");
		stringType.put(Type.CREVAISON, "Roue De Secours");
		stringType.put(Type.ACCIDENT, "Réparations");
	}
	
	public Parade(Type t, int n) {
		super(t, n);
	}
	
	@Override
	public boolean appliquer(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}
}
