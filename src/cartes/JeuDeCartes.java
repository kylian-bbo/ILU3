package cartes;

import java.util.ArrayList;

import utils.Utils;

public class JeuDeCartes {
	
	private ArrayList<Carte> listeCartes = new ArrayList<>();
	private static Carte[] typesDeCartes = {
			//Bottes
			new Botte(Type.FEU, 1),
			new Botte(Type.ESSENCE, 1),
			new Botte(Type.CREVAISON, 1),
			new Botte(Type.ACCIDENT, 1),
			//Attaques
			new Attaque(Type.FEU, 5),
			new DebutLimite(4),
			new Attaque(Type.ESSENCE, 3),
			new Attaque(Type.CREVAISON, 3),
			new Attaque(Type.ACCIDENT, 3),
			//Parades
			new Parade(Type.FEU, 14),
			new FinLimite(6),
			new Parade(Type.ESSENCE, 6),
			new Parade(Type.CREVAISON, 6),
			new Parade(Type.ACCIDENT, 6),
			//Bornes
			new Borne(25, 10),
			new Borne(50, 10),
			new Borne(75, 10),
			new Borne(100, 12),
			new Borne(200, 4)
	};
	
	public JeuDeCartes() {
		listeCartes = Utils.melanger(initialiserListeCartes());
	}
	
	private ArrayList<Carte> initialiserListeCartes() {
		ArrayList<Carte> listeCarteTemp = new ArrayList<>();
		
		for (int i = 0; i < typesDeCartes.length; i++)
			for (int j = 0; j < typesDeCartes[i].nombre; j++)
				listeCarteTemp.add(typesDeCartes[i]);
		
		return listeCarteTemp;
	}

	public ArrayList<Carte> getListeCartes() {
		return listeCartes;
	}
}