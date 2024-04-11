package jeu;

import cartes.Carte;
import cartes.Attaque;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;

public class Coup {
	private Carte carte;
	private Joueur cible;

	public Coup(Carte carte, Joueur cible) {
		this.carte = carte;
		this.cible = cible;
	}
	
	public Carte getCarte() {
		return carte;
	}
	
	public Joueur getCible() {
		return cible;
	}
	
	public boolean estValide(Joueur joueur) {
		if (carte instanceof Attaque || carte instanceof DebutLimite)
			return !joueur.equals(cible);

		if (carte instanceof Parade || carte instanceof FinLimite || carte instanceof Botte) // Cas en plus
			return joueur.equals(cible);
		
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Coup coup = (Coup) obj;
			return coup.getCarte() == carte && coup.getCible() == cible;
		}
		return false;
	}

	@Override
	public int hashCode() {
		if (cible != null)
			return 31*(carte.hashCode() + cible.hashCode());
			return 29*(carte.hashCode());
		// Ajouter hashCode dans Carte et Joueur ? 
	}

	@Override
	public String toString() {
		String string = "Deposer la carte " + carte.toString();

		if (cible != null)
			return string + " dans la zone de jeu de " + cible.toString();
		return string + " dans la defausse";
	}
}