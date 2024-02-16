package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	private static final int CAPACITE = 110;
	
	private Carte[] sabot;
	private int nbCartes;
	//(Pour l'iterateur)
	private int nbOperations;
	
	
	public Sabot() {
		this.sabot = new Carte[CAPACITE];
		this.nbCartes = 0;
		nbOperations = 0;
	}
	
	public boolean estVide() {
		return nbCartes == 0;
	}

	private void ajouterCarte(Carte carte) throws Exception {
		if (nbCartes < CAPACITE) {
			sabot[nbCartes] = carte;
			nbCartes++;
		}
		else
			throw new Exception("Capacite du sabot atteinte.");
	}
	
	public void ajouterFamilleCarte(Carte carte) throws Exception {
		for (int i = 0; i < carte.getNombre(); i++) {
			ajouterCarte(carte);
		}
	}
	
	public void ajouterFamilleCarte(Carte... cartes) throws Exception {
		for (Carte carte : cartes) {
			ajouterFamilleCarte(carte);
		}
	}
	
	public Carte piocher() {
		Iterator<Carte> iterateur = iterator();
		
		Carte carte = iterateur.next();
		iterateur.remove();
		return carte;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new Iterateur();
	}
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsReference = nbOperations;

		@Override
		public boolean hasNext() {
			return indiceIterateur < nbCartes;
		}

		@Override
		public Carte next() {
			verificationConcurrence();
			
			if (hasNext()) {
				Carte carte = sabot[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				nbOperations ++;
				nbOperationsReference++;
				return carte;
			}
			else 
				throw new NoSuchElementException();
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			
			if (nbCartes < 1 || !nextEffectue)
				throw new IllegalStateException();
			
			for (int i = indiceIterateur - 1; i < nbCartes - 1; i++)
				sabot[i] = sabot[i + 1];
			
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nbOperations ++;
			nbOperationsReference++;
		}
		
		private void verificationConcurrence() {
			if (nbOperations != nbOperationsReference)
				throw new ConcurrentModificationException();
		}
	}
}