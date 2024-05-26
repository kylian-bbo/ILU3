package jeu;

import java.util.ArrayList;
import java.util.HashSet;

import cartes.Carte;
import cartes.JeuDeCartes;
import utils.Utils;

public class Jeu {
	
	private HashSet<Joueur> joueurs;
	private JeuDeCartes jeuDeCartes;
	private Sabot sabot;
	
	public Jeu() {
		joueurs = new HashSet<>();
		jeuDeCartes = new JeuDeCartes();
		sabot = new Sabot(110);
	}
	
	
	public void inscrire(Joueur j) {
		if (!joueurs.contains(j)) {
			joueurs.add(j);
			j.setJeu(this);
			System.out.println("Joueur " + j.toString() + " inscrit au jeu.");
		}
		else 
			System.out.println("Joueur " + j.toString() + "déjà inscrit au jeu.");
	}
	
	public void distribuerCartes()  {
		for (int i = 0; i < 6; i++)
			for (Joueur joueur : joueurs) {
				joueur.donner(Utils.extraire(jeuDeCartes.getListeCartes()));
			}
		
		
	
	}
}















