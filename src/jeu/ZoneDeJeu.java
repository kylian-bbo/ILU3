package jeu;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Botte;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;
import cartes.Type;

public class ZoneDeJeu {
	private List<Limite> limites;
	private List<Bataille> batailles;
	private Collection<Borne> bornes;
	private Set<Botte> bottes;

    public ZoneDeJeu() {
		
		limites = new LinkedList<>();
		batailles = new LinkedList<>();
		bornes = new LinkedList<>();
		bottes = new HashSet<>();
	}

	//Pour TestZoneDeJeu
	public void effacerBottes() {
		bottes.clear();
	}

	public void deposer(Limite limite) {
		limites.add(limite);
	}

    public void deposer(Borne borne) {
        bornes.add(borne);
    }

	public void deposer(Bataille bataille) {
		batailles.add(bataille);
	}

	public void deposer(Botte botte) {
		bottes.add(botte);
	}

    public int donnerKmParcourus() {
        int kmParcourus = 0;
		
		for (Borne carte : bornes) {
			kmParcourus += carte.getKm();
		}
			
		return kmParcourus;
    }

	private boolean estPrioritaire() {
		return bottes.contains(new Botte(1, Type.FEU));
	}

    public int donnerLimitationVitesse() {
        if (limites.isEmpty()
				|| limites.get(limites.size() - 1) instanceof FinLimite
				|| estPrioritaire())
			return 200;
		return 50;
    }

	public boolean estBloque() {

		// la pile de bataille est vide et il est prioritaire
		if (batailles.isEmpty() && estPrioritaire())
			return false;

		if (!batailles.isEmpty()) {
			Bataille sommet = batailles.get(batailles.size() - 1); 

			// le sommet est une parade de type FEU
			if (sommet instanceof Parade && sommet.getType().equals(Type.FEU))
				return false;

			// le sommet est une parade et il est prioritaire
			if (sommet instanceof Parade && estPrioritaire())
				return false;

			// le sommet est une attaque de type FEU et il est prioritaire
			if (sommet instanceof Attaque && sommet.getType().equals(Type.FEU) && estPrioritaire())
				return false;
			
			// le sommet est une attaque d’un autre type pour lequel il a une botte et il est prioritaire
			if (sommet instanceof Attaque && !sommet.getType().equals(Type.FEU)) {
				boolean botteTypeSommet = false;

				for (Botte botte : bottes)
					if (botte.getType().equals(sommet.getType()))
						botteTypeSommet = true;
						
				if (botteTypeSommet && estPrioritaire())
					return false;
			}
		}
		
		return true;
	}
}