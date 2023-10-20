package jeu;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import cartes.Carte;
import cartes.Bataille;
import cartes.Limite;
import cartes.FinLimite;
import cartes.Borne;
import cartes.Botte;


public class Joueur {
	private String nom;
	private Main main = new MainAsListe();

	private List<Limite> limites = new ArrayList<>();
	private List<Bataille> batailles = new ArrayList<>();
	private Collection<Borne> bornes = new ArrayList<>();
	private Set<Botte> bottes = new HashSet<>();
	
	public Joueur(String nom) {
		this.nom = nom;
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
	
	public boolean equals(Joueur joueur) {
		return (this.nom).equals(joueur.toString());
	}
	
	public void donner(Carte carte) {
		main.prendre(carte);
	}
	
	public Carte prendreCarte(List<Carte> sabot) {
		int tailleSabot = sabot.size();
		
		if (tailleSabot > 0)
			return sabot.remove(tailleSabot - 1);
		else
			return null;
	}
	
	public int getKM() {
		int km = 0;
		
		for (Borne borne : bornes)
			km += borne.getKm();
	
		return km;
	}
	
	public int getLimite() {
		if (!limites.isEmpty() && limites.get(limites.size()) instanceof FinLimite)
			
		
		return 200;
	}
}
