package testsFonctionnels;

import cartes.JeuDeCartes;
import jeu.Jeu;
import jeu.Joueur;

public class TestJeu {
    public static void main(String[] args) throws Exception {
        
        // TP4 - Un tour de jeu
        // 2)

        System.out.println("\nTP4 - Un tour de jeu\n2)\n");

        Jeu jeu = new Jeu();

        Joueur j1 = new Joueur("J1");
        Joueur j2 = new Joueur("J2");

        jeu.remplirSabot(new JeuDeCartes());

        jeu.inscrire(j1);
        jeu.inscrire(j2);
        jeu.distribuerCartes();
        jeu.jouerTourTP4();

        System.out.println();
    }
}