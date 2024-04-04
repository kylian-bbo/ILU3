package testsFonctionnels;

import cartes.Attaque;
import cartes.Botte;
import cartes.Parade;
import cartes.Type;
import jeu.ZoneDeJeu;

public class TestZoneDeJeu {
    
    public static void main(String[] args) {

        // 15)
        System.out.println("15)");

        ZoneDeJeu zoneDeJeu = new ZoneDeJeu();

        zoneDeJeu.deposer(new Attaque(1, Type.FEU));
        System.out.print("\t" + zoneDeJeu.estBloque() + ", ");
        zoneDeJeu.deposer(new Botte(1, Type.FEU));
        System.out.print(zoneDeJeu.estBloque() + ", ");
        zoneDeJeu.deposer(new Attaque(1, Type.ACCIDENT));
        System.out.print(zoneDeJeu.estBloque() + ", ");
        zoneDeJeu.deposer(new Botte(1, Type.ACCIDENT));
        System.out.print(zoneDeJeu.estBloque() + ", ");
        zoneDeJeu.deposer(new Attaque(1, Type.ESSENCE));
        System.out.print(zoneDeJeu.estBloque() + ", ");
        zoneDeJeu.deposer(new Botte(1, Type.ESSENCE));
        System.out.print(zoneDeJeu.estBloque() + ", ");
        zoneDeJeu.effacerBottes();
        System.out.print(zoneDeJeu.estBloque() + ", ");
        zoneDeJeu.deposer(new Parade(1, Type.FEU));
        System.out.println(zoneDeJeu.estBloque());
    }
}
