package cartes;

import jeu.Joueur;

public class DebutLimite extends Limite {

	public DebutLimite(int n) {
		super(n);
	}
	
	public String toString() {
		return "Limite de vitesse";
	}

	@Override
	public boolean appliquer(Joueur j) {
		boolean joueurPrioritaire = false;
		
		for (Botte botte : j.getBottes())
			if (botte.type == Type.FEU)
				joueurPrioritaire = true;
		
		if (!joueurPrioritaire && )
		
	}
}