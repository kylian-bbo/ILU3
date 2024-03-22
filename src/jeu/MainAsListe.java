package jeu;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import cartes.Carte;

public class MainAsListe implements Main {
	private List<Carte> liste;
	
	public MainAsListe() {
		liste = new LinkedList<>();
	}

	@Override
	public Iterator<Carte> iterator() {
		return liste.iterator();
	}

	@Override
	public void prendre(Carte carte) {
		liste.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assert liste.contains(carte);
		
		liste.remove(carte);
	}
}
