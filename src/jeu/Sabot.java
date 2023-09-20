package jeu;

import java.util.Iterator;
import java.util.ConcurrentModificationException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
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
	
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur =0;
		private int nbOperationsReference = nbCartes;
		private boolean nextEffectue = false;
		
		public boolean hasNext() {
			
		}
		
		public Carte next() {
			
		}
		
		public void remove() {
			
		}
		
		private void verificationConcurrence() {
			if (nbOperationsReference != nbCartes)
				throw new ConcurrentModificationException();
		}
	}
}