package utils;

import java.util.ArrayList;

import cartes.Carte;

public class Utils {

	public Utils() {
	}
	
	public static Carte extraire(ArrayList<Carte> listeCartes) {
		int n = (int)(Math.random() * listeCartes.size());
		Carte carte = listeCartes.get(n);
		listeCartes.remove(n);
		
		return carte;
	}
	
	public static ArrayList<Carte> melanger(ArrayList<Carte> listeCartes) {
		ArrayList<Carte> listeCartesMelangee = new ArrayList<>();
		
		//TODO Melanger les cartes
		
		return listeCartes; //Temp
		//return listeCartesMelangee;
		}
}
