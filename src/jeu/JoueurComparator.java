package jeu;

import java.util.Comparator;

public class JoueurComparator implements Comparator<Joueur> {

	@Override
	public int compare(Joueur j1, Joueur j2) {
		Integer kmJ1 = j1.donnerKmParcourus();
		Integer kmJ2 = j2.donnerKmParcourus();
		return kmJ2.compareTo(kmJ1);
	}
}
