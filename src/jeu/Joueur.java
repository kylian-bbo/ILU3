package jeu;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Type;

public class Joueur {
	private String nom;
	private Main main;
	
	private List<Limite> limites;
	private List<Bataille> batailles;
	private Collection<Borne> bornes;
	private Set<Botte> bottes;

	public Joueur(String nom) {
		this.nom = nom;
		this.main = new MainAsListe();
		
		limites = new LinkedList<>();
		batailles = new LinkedList<>();
		bornes = new LinkedList<>();
		bottes = new HashSet<>();
	}
	
	public String toString() {
		return nom;
	}
	
	public Main getMain() {
		return main;
	}

	public List<Limite> getLimites() {
		return limites;
	}

	public List<Bataille> getBatailles() {
		return batailles;
	}

	public Collection<Borne> getBornes() {
		return bornes;
	}

	public Set<Botte> getBottes() {
		return bottes;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Joueur joueur = (Joueur) obj;
			return nom.equals(joueur.toString());
		}
		return false;
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
		// Post-condition : La main contient la carte.
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		if (!sabot.isEmpty()) {
			Carte carte = sabot.remove(0);
			donner(carte);
			return carte;
		}
		return null;
	}
	
	public int getKM() {
		int km = 0;
		
		for (Borne carte : bornes) {
			km += carte.getKm();
		}
			
		return km;
	}
	
	public int getLimite() {
		if (limites.isEmpty()
				|| limites.get(limites.size() - 1) instanceof FinLimite 
				|| bottes.contains(new Botte(1, Type.FEU)))
			return 200;
		return 50;
	}
}
