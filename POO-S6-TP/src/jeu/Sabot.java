package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte> {
    private Carte[] sabot;
    private int tailleSabot;
    private int nbCartes;
    private int nbOperations;
    
    public Sabot(int taille) {
        this.sabot = new Carte[taille];
        this.tailleSabot = taille;
        this.nbCartes = 0;
		this.nbOperations = 0;
    }
    
    public boolean estVide() {
        return nbCartes == 0;
    }

    public void ajouterCarte(Carte carte) throws Exception {
        if (nbCartes < tailleSabot) {
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