package jeu;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu {
    Set<Joueur> joueurs;
    Sabot sabot;

    public Jeu() {
        this.joueurs = new LinkedHashSet<>();
        this.sabot = new Sabot(106);
    }

    public void inscrire(Joueur joueur) {
        joueurs.add(joueur);
    }

    public void remplirSabot(JeuDeCartes jeu) throws Exception {
        List<Carte> listeCartes = jeu.getListeCartes();
        
        for (Carte carte : listeCartes) {
            sabot.ajouterCarte(carte);
        }
    }

    public void distribuerCartes() {
        for (int nbCartesDistribuees = 0; nbCartesDistribuees < 6; nbCartesDistribuees++) {
            for (Joueur joueur : joueurs)
                joueur.donner(sabot.piocher());
        }
    }

    public void JouerTour() {

        for (Joueur joueur : joueurs)
            System.out.println("Le joueur " + joueur.toString() + " a en main : " + joueur.getMain().toString());

        for (Joueur joueur : joueurs) {
            
            joueurPrendreCarte(joueur);
            joueurChoisirCoup(joueur);
        }
    }

    private void joueurPrendreCarte(Joueur joueur) {

        if (!sabot.estVide()) {
            Carte cartePiochee = sabot.piocher();
            joueur.donner(cartePiochee);

            System.out.println("Le joueur " + joueur.getNom() + " a pioche "
                                + cartePiochee.toString());
        }
        else {
            System.out.println("Le sabot est vide.");
            //TODO Sabot vide -> Défausse ?
            return;
        }
    }

    private void joueurChoisirCoup(Joueur joueur) {
        Set<Coup> coupsPossibles;
        Coup coupChoisi;
        Joueur cible;
        Carte carte;

        coupsPossibles = joueur.coupsPossibles(joueurs);
        if (coupsPossibles.isEmpty())
           coupsPossibles = joueur.coupsDefausse();
            //TODO Ajouter une defausse ?

        coupChoisi = joueur.choisirCoup(coupsPossibles);

        joueur.retirerDeLaMain(coupChoisi.getCarte());

        cible = coupChoisi.getCible();
        carte = coupChoisi.getCarte();

        if (cible != null)
            cible.deposer(carte);
        
        System.out.println("Le joueur " + joueur.toString() 
                         + " a choisi le coup \"" + coupChoisi.toString() + "\"");   
    }
}