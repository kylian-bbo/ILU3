package testsFonctionnels;

import java.util.Iterator;
import jeu.Sabot;
import cartes.Carte;
import cartes.Type;
import cartes.Botte;
import cartes.Attaque;
import cartes.Parade;


public class TestsFonctionnels {


	public static void main(String[] args) throws Exception {
		Sabot sabot = new Sabot(110);

		sabot.ajouterFamilleCarte(
				new Attaque(Type.ACCIDENT, 3),
				new Parade(Type.ACCIDENT, 3),
				new Botte(Type.ACCIDENT, 1)
				);
		
		Iterator<Carte> iterateur = sabot.iterator();
		
		Carte carte = null;
		while (!sabot.estVide()) {
			carte = sabot.piocher(iterateur);
			//sabot.ajouterFamilleCarte(new Botte(Type.ACCIDENT, 1)); //Pour la question 2. c)
			System.out.println("Je pioche " + carte.toString());
		}
	}
}
