package tests;

import jeu.Jeu;
import jeu.Joueur;

public class TestTP5 {
    public static void main(String[] args) throws Exception {
		Joueur j1 = new Joueur("J1");
		Joueur j2 = new Joueur("J2");
		Joueur j3 = new Joueur("J3");
		
		Jeu jeu = new Jeu();
		
		jeu.inscrire(j1);
		jeu.inscrire(j2);
		jeu.inscrire(j3);
		
		jeu.lancer();
	}
}
