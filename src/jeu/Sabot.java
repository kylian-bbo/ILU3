package jeu;

import cartes.Carte;

public class Sabot {
	private Carte[] pioche;
	private int capacite;
	private int nbCartes = 0;

	
	public Sabot(int capacite, int nbCartes) {
		this.pioche = new Carte[capacite];
		this.capacite = capacite;
		this.nbCartes = nbCartes;
	}
	
	public Boolean estVide() {
		return nbCartes == 0;
	}
	
	private void ajouterCarte(Carte carte) throws Exception {
		if (nbCartes < capacite) {
			pioche[nbCartes] = carte;
			nbCartes++;
		}
		else
			throw new RuntimeException("Capacité du sabot atteinte.");
	}
	
	public void ajouterFamilleCarte(Carte carte) throws Exception {
		for (int i=0; i<carte.getNombre(); i ++)
			ajouterCarte(carte);
	}
	
	public void ajouterFamilleCarte(Carte... cartes) throws Exception {
		for (Carte carte : cartes) {
			ajouterCarte(carte);
		}
	}
}