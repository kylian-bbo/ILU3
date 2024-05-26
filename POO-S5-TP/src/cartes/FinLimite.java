package cartes;

import jeu.Joueur;

public class FinLimite extends Limite {

	public FinLimite(int n) {
		super(n);
	}
	
	public String toString() {
		return "Fin de limite de vitesse";
	}

	@Override
	public boolean appliquer(Joueur j) {
		// TODO Auto-generated method stub
		return false;
	}
}
