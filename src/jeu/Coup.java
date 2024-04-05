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
	
	public boolean estValide(Joueur joueur) {
		if (carte instanceof Attaque || carte instanceof DebutLimite)
			return !joueur.equals(cible);
		
		return true;
	}
}