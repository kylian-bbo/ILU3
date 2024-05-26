package cartes;

import java.util.LinkedList;
import java.util.List;
import utils.Utils;

public class JeuDeCartes {
	private Carte[] typesDeCartes = {
			// Bottes
			new Botte(1, Type.FEU),
			new Botte(1, Type.ESSENCE),
			new Botte(1, Type.CREVAISON),
			new Botte(1, Type.ACCIDENT),
			// Attaques
			new Attaque(5, Type.FEU),
			new DebutLimite(4),
			new Attaque(3, Type.ESSENCE),
			new Attaque(3, Type.CREVAISON),
			new Attaque(3, Type.ACCIDENT),
			// Parades
			new Parade(14, Type.FEU),
			new FinLimite(6),
			new Parade(6, Type.ESSENCE),
			new Parade(6, Type.CREVAISON),
			new Parade(6, Type.ACCIDENT),
			// Bornes
			new Borne(10, 25),
			new Borne(10, 50),
			new Borne(10, 75),
			new Borne(12, 100),
			new Borne(4, 200) };
	
	private List<Carte> listeCartes = new LinkedList<>();

	public JeuDeCartes() {
		initialiserListeCartes();
	}
	
	private void initialiserListeCartes() {
		List<Carte> listeTemp = new LinkedList<>();
		
		for (int i = 0; i < typesDeCartes.length; i++)
			for (int j = 0; j < typesDeCartes[i].getNombre(); j++)
				listeTemp.add(typesDeCartes[i]);
		
		listeCartes = Utils.melanger(listeTemp);
	}
	
	public List<Carte> getListeCartes() {
		return listeCartes;
	}
	
	public boolean checkCount() { // TODO : Verifier pour chaque type de cartes. Faire une deuxieme fonction Count pour un type de carte en particulier.
		return listeCartes.size() == 106; // 106 cartes au total, en retirant les 4 cartes memo
	}
}
