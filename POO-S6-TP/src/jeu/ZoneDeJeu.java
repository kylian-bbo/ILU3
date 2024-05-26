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
import cartes.Carte;
import cartes.DebutLimite;
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
			
			// le sommet est une attaque dâ€™un autre type pour lequel il a une botte et il est prioritaire
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
	
	private boolean aBotteType(Type type) {
		boolean res = false;
		
		for (Botte botte : bottes)
			if (botte.getType().equals(type))
				res = true;
		
		return res;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne borne)
			return estDepotAutoriseBorne(borne);
		if (carte instanceof Botte)
			return true;
		if (carte instanceof DebutLimite)
			return estDepotAutoriseDebutLimite();
		if (carte instanceof FinLimite)
			return estDepotAutoriseFinLimite();
		if (carte instanceof Bataille bataille)
			return estDepotAutoriseBataille(bataille);
		
		return false;
	}
	
	private boolean estDepotAutoriseBorne(Borne borne) {
		// si la carte est une borne : si le joueur n’est pas bloqué, la borne ne dépasse pas
		// la vitesse limite et que la somme des bornes ne dépasse pas 1000
		return !estBloque() && borne.getKm() <= donnerLimitationVitesse() && donnerKmParcourus() < 1000;
	}
	
	private boolean estDepotAutoriseDebutLimite() {
		// si la carte est une limitation de vitesse : si le joueur n’a pas la botte
		// prioritaire et n’a pas déjà une limite de vitesse
		return !estPrioritaire() && donnerLimitationVitesse() == 200;
	}
	
	private boolean estDepotAutoriseFinLimite() {
		// si la carte est une fin de limite de vitesse : si le joueur n’a pas de botte
		// prioritaire et a une vitesse limitée
		return !estPrioritaire() && donnerLimitationVitesse() == 50;
	}
	
	private boolean estDepotAutoriseBataille(Bataille bataille) {
		// si la carte est de type Bataille, on récupère dans la variable top le sommet 
		// de la pile de batailles du joueur. Si la pile est vide, top désignera le feu
		// vert lorsque le véhicule est prioritaire ou que la carte jouée est le feu rouge,
		// et le feu rouge sinon.
		Bataille top;
			
		if (batailles.isEmpty()) {
			if (estPrioritaire() || bataille.equals(new Attaque(1, Type.FEU)))
				top = new Parade(1, Type.FEU);
			else
				top = new Attaque(1, Type.FEU);
		}
		else
			top = batailles.get(batailles.size() - 1);

		Type typeTop = top.getType();
		// si top est une attaque et qu’il n’y a pas de botte du même type, la carte jouée
		// peut être une parade du même type.
		if (top instanceof Attaque
				&& !aBotteType(typeTop)
				&& bataille.equals(new Parade(1, typeTop)))
			return true;
		// si top est une parade, une attaque peut être jouée si le joueur n’a pas déposé
		// la botte correspondante
		return (top instanceof Parade
				&& bataille instanceof Attaque
				&& !aBotteType((bataille.getType())));
	}

	public boolean deposer(Carte c) {
		if (estDepotAutorise(c)) {
			if (c instanceof Borne) {
				deposer((Borne) c);
				return true;
			}
			if (c instanceof Botte) {
				Botte botte = (Botte) c;
				deposer(botte);
				
				if (!batailles.isEmpty()) {
					Bataille topBatailles = batailles.get(batailles.size() - 1);
					
					if (topBatailles instanceof Attaque && topBatailles.getType() == botte.getType())
						batailles.remove(batailles.size() - 1);
				}
	
				return true;
			}
			if (c instanceof Limite) {
				deposer((Limite) c);
				return true;
			}
			if (c instanceof Bataille) {
				deposer((Bataille) c);
				return true;
			}
		}
		
		return false;
	}
}