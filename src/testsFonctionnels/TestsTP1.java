package testsFonctionnels;

import java.util.Iterator;

import cartes.Attaque;
import cartes.Botte;
import cartes.Carte;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class TestsTP1 {

	public static void main(String[] args) throws Exception {
		Sabot sabot = new Sabot();
		
		// 2. a)
		sabot.ajouterFamilleCarte(
				new Attaque(3, Type.ACCIDENT),
				new Parade(3, Type.ACCIDENT),
				new Botte(1, Type.ACCIDENT));
		
		System.out.println("2. a)");
		while (!sabot.estVide())
			System.out.println("\tJe pioche " + sabot.piocher().toString()); 
		
		// 2. b)
		sabot.ajouterFamilleCarte(
				new Attaque(3, Type.ACCIDENT),
				new Parade(3, Type.ACCIDENT),
				new Botte(1, Type.ACCIDENT));
		
		Iterator<Carte> iterateur = sabot.iterator();
		
		System.out.println("\n2. b)");
		while (!sabot.estVide()) {
			System.out.println("\tJe pioche " + iterateur.next().toString());
			/* 2. c)
			sabot.piocher();
			sabot.ajouterFamilleCarte(new Botte(1, Type.ACCIDENT));
			*/
			iterateur.remove();
		}
	}
}
