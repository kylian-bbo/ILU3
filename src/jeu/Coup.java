package jeu;

import cartes.Carte;
import cartes.Attaque;
import cartes.DebutLimite;

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
	
	public boolean estValide(Joueur j) {
		if (carte instanceof Attaque || carte instanceof DebutLimite)
			return !cible.equals(j);
		return true;
	}
	
	public boolean equals(Object objet) {
		if (objet != null && getClass() == objet.getClass()) {
			Coup coupToCompare = (Coup) objet;
			return carte.equals(coupToCompare.getCarte()) && cible.equals(coupToCompare.getCible());
		}
		return false;
	}
	
	public int hashCode() {
		return 31 * (carte.hashCode() + cible.hashCode());
	}
}
