package tests;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Borne;
import cartes.Carte;
import cartes.DebutLimite;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Type;

import utils.Utils;

public class TestsTP2 {

	public static void main(String[] args) {
		// 1)
		System.out.println("1)");
		Borne C1 = new Borne(1, 25);
		Borne C2 = C1;
		DebutLimite C3 = new DebutLimite(1);
		
		System.out.println("\t" + C1.equals(C2));
		System.out.println("\t" + C1.equals(C3));
		
		Attaque C4 = new Attaque(1, Type.FEU);
		Parade C5 = new Parade(1, Type.FEU);
		
		System.out.println("\t" + C4.equals(C5));
		
		// 3)
		System.out.println("3)");
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCartes1 = jeuDeCartes.getListeCartes();
		
		System.out.println("\t" + listeCartes1.toString());
		System.out.println("\t" + jeuDeCartes.checkCount());
		
		// 5)
		System.out.println("5)");
		JeuDeCartes jeu = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = jeu.getListeCartes();
		List<Carte> listeCartes = new ArrayList<>(listeCarteNonMelangee);
		System.out.println("\t" + listeCartes);
		listeCartes = Utils.melanger(listeCartes);
		System.out.println("\t" + listeCartes);
		System.out.println("\t" + "liste mélangée sans erreur ? "
				+ Utils.verifierMelange(listeCarteNonMelangee, listeCartes));
		listeCartes = Utils.rassembler(listeCartes);
		System.out.println("\t" + listeCartes);
		System.out.println("\t" + "liste rassemblée sans erreur ? " + Utils.verifierRassemblement(listeCartes));
	
		// 7)
		System.out.println("7)");
		JeuDeCartes jeu2 = new JeuDeCartes();
		System.out.println("\tNombre d'occurences de chaques cartes respecté ? " + jeu2.checkCount());
	
	}
}
