package tests;

import cartes.Borne;
import cartes.Botte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Type;
import jeu.Joueur;

public class TestTP3 {

	public static void main(String[] args) {
		
		// 8)
		System.out.println("8)");
		Joueur j1 = new Joueur("Joueur 1");
		
		Borne b1 = new Borne(1, 75);
		Borne b2 = new Borne(1, 25);
		Borne b3 = new Borne (1, 100);
		
		j1.getBornes().add(b1);
		j1.getBornes().add(b2);
		j1.getBornes().add(b3);
		
		assert j1.getKM() == 200;
		System.out.println("\tKilometrage atteint par le joueur = " + j1.getKM() + " km");
	
		// 10)
		System.out.println("10)");
		
		Limite debutLimite = new DebutLimite(1);
		Limite finLimite = new FinLimite(1);	
		Botte prioritaire = new Botte(1, Type.FEU);
		
		System.out.println("\tLimite de vitesse du joueur avec pile vide : " + j1.getLimite());
		
		j1.getLimites().add(debutLimite);
		System.out.println("\tLimite de vitesse du joueur avec debutLimite : "  + j1.getLimite());
		
		j1.getLimites().add(finLimite);
		System.out.println("\tLimite de vitesse du joueur avec finLimite : "  + j1.getLimite());
	
		j1.getLimites().add(debutLimite);
		j1.getBottes().add(prioritaire);
		System.out.println("\tLimite de vitesse du joueur avec botte véhicule prioritaire : " + j1.getLimite());
		
	}
}
