package tests;

import cartes.Attaque;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Parade;
import cartes.Type;
import jeu.Joueur;

public class TestsTP4 {
    public static void main(String[] args) {
        
        //Jouer une carte
        // 2)
        System.out.println("2)");
        Joueur jt = new Joueur("Joueur Test");

        Carte[] cartes = { 
                        new Attaque(1, Type.FEU),
                        new Attaque(1, Type.ACCIDENT),
                        new Botte(1, Type.ACCIDENT),
                        new Attaque(1, Type.ESSENCE),
                        new Parade(1, Type.ESSENCE),
                        new Parade(1, Type.FEU),
                        new Borne(1, 100),
                        new DebutLimite(1),
                        new Borne(1, 100),
                        new Borne(1, 25),
                        new FinLimite(1),
                        new Borne(1, 100)
                        };

        for (Carte carte : cartes) {
            System.out.println("\tDeposer " + carte.toString() + " : depot ok ? " + jt.deposer(carte)
                                + ", bloque ? " + jt.estBloque());
        }
    }
}
