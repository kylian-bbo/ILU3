package jeu;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import cartes.Carte;


public class MainAsListe implements Main {
	private List<Carte> main = new ArrayList<>();
	
	@Override
	public Iterator<Carte> iterator() {
		return main.iterator();
	}

	@Override
	public void prendre(Carte carte) {
		main.add(carte);
	}

	@Override
	public void jouer(Carte carte) {
		assert main.contains(carte);
		main.remove(carte);
	}
}
