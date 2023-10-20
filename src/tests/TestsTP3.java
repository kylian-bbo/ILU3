package tests;

import cartes.Borne;
import jeu.Joueur;

public class TestsTP3 {
	
	public static void testGetKM() {
		Joueur joueur = new Joueur("Joueur");
		
		Borne b1 = new Borne(25, 1);
		Borne b2 = new Borne(75, 1);
		Borne b3 = new Borne (200, 1);
		
		joueur.getBornes().add(b1);
		joueur.getBornes().add(b2);
		joueur.getBornes().add(b3);
		
		int km = joueur.getKM();
		
		assert km == 300;
		System.out.println("getKM -> " + km);
	}
	
	public static void main(String[] args) {
		testGetKM();
	}
}
