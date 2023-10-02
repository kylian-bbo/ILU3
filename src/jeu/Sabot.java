package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
	private Carte[] pioche;
	private int capacite;
	private int nbCartes = 0;

	public Sabot(int capacite) {
		this.pioche = new Carte[capacite];
		this.capacite = capacite;
	}
	
	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	public int getNbCartes() {
		return nbCartes;
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
		for (int i = 0; i < carte.getNombre(); i++)
			ajouterCarte(carte);
	}
	
	public void ajouterFamilleCarte(Carte... cartes) throws Exception {
		for (Carte carte : cartes)
			ajouterFamilleCarte(carte);
	}
	
	public Carte piocher(Iterator<Carte> iterator) {
		Carte carte = iterator.next();
		iterator.remove();
		return carte;
	}
	
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private int nbCartesReference = nbCartes;
		private boolean nextEffectue = false;
		
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}
		
		public Carte next() {
			verificationConcurrence();
			if (hasNext()) {
				Carte carte = pioche[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			}
			else
				throw new NoSuchElementException();
		}
		
		public void remove() {
			verificationConcurrence();
			if (nbCartes < 1 || !nextEffectue)
				throw new IllegalStateException();
			else {
				for(int i = indiceIterateur - 1; i < nbCartes - 1; i++)
					pioche[i] = pioche [i+1];
				nextEffectue = false;
				indiceIterateur--;
				nbCartes--;
				nbCartesReference--;
			}
		}
		
		private void verificationConcurrence() {
			if (nbCartesReference != nbCartes)
				throw new ConcurrentModificationException();
		}
	}
}