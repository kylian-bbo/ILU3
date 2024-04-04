package jeu;

import cartes.Carte;
import cartes.Parade;
import cartes.Attaque;
import cartes.Botte;
import cartes.Type;

public interface Cartes {
    public static final Carte PRIORITAIRE = new Botte(1, Type.FEU);
    public static final Carte FEU_ROUGE = new Attaque(1, Type.FEU);
    public static final Carte FEU_VERT = new Parade(1, Type.FEU);
}