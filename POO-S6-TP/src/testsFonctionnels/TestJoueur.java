package testsFonctionnels;

import cartes.Borne;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Botte;
import cartes.Type;

import jeu.Joueur;

public class TestJoueur {

    public static void main(String[] args) {
        
        // 10)
		System.out.println("10)");
		
		Joueur j1 = new Joueur("Joueur 1");
		
		j1.deposer(new Borne(1, 75));
        j1.deposer(new Borne(1, 25));
        j1.deposer(new Borne(1, 200));
		
		assert j1.donnerKmParcourus() == 200;
		System.out.println("\tKilometrage atteint par le joueur = " + j1.donnerKmParcourus() + " km");
    
        // 13)
		System.out.println("13)");
		
		System.out.println("\tLimite de vitesse du joueur avec pile vide : " + j1.donnerLimitationVitesse());
		
		j1.deposer(new DebutLimite(1));
		System.out.println("\tLimite de vitesse du joueur avec DebutLimite en haut de la pile : "  + j1.donnerLimitationVitesse());
		
		j1.deposer(new FinLimite(1));
		System.out.println("\tLimite de vitesse du joueur avec FinLimite en haut de la pile : "  + j1.donnerLimitationVitesse());
        
		j1.deposer(new DebutLimite(1));
		j1.deposer(new Botte(1, Type.FEU));
		System.out.println("\tLimite de vitesse du joueur avec botte vehicule prioritaire : " + j1.donnerLimitationVitesse());
    }
}