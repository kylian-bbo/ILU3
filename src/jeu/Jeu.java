package jeu;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Jeu {
    Set<Joueur> joueurs;
    Sabot sabot;
    Iterator<Joueur> iterateurJoueurs;
    int nbTours;
    Boolean joueurAJoue;

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
    
    public void jouerTourTP4() {
        
    	for (Joueur joueur : joueurs) {
        	joueurPrendreCarte(joueur);
        	System.out.println("Il a dans sa main : " + joueur.getMain().toString());
        	joueurChoisirCoup(joueur);
    	}
    }

    public boolean jouerTour(Joueur joueur) {
    	joueurPrendreCarte(joueur);
    	System.out.println("Il a dans sa main : " + joueur.getMain().toString());
    	return joueurChoisirCoup(joueur);
    }

    private void joueurPrendreCarte(Joueur joueur) {

        if (!sabotEstVide()) {
            Carte cartePiochee = sabot.piocher();
            joueur.donner(cartePiochee);

            System.out.println("Le joueur " + joueur.getNom() + " a pioche "
                                + cartePiochee.toString());
        }
        else {
        	System.out.println("Le joueur " + joueur.getNom() + " - Le sabot est vide");
        }
    }

    private boolean joueurChoisirCoup(Joueur joueur) {
        Set<Coup> coupsPossibles;
        Coup coupChoisi;
        Joueur cible;
        Carte carte;

        coupsPossibles = joueur.coupsPossibles(joueurs);
        if (coupsPossibles.isEmpty())
           coupsPossibles = joueur.coupsDefausse();
        
        if (coupsPossibles.isEmpty())
        	//Plus de cartes, le joueur n'a pas pu jouer
        	return false;
        	
        coupChoisi = joueur.choisirCoup(coupsPossibles);

        joueur.retirerDeLaMain(coupChoisi.getCarte());

        cible = coupChoisi.getCible();
        carte = coupChoisi.getCarte();

        if (cible != null)
            cible.deposer(carte);
        
        System.out.println("\"" + coupChoisi.toString() + "\"");  
        System.out.println("Le joueur a parcouru " + joueur.donnerKmParcourus() + "km\n");
        return true;
    }
    
    public Joueur donnerJoueurSuivant() {
    	if (!iterateurJoueurs.hasNext())
    		iterateurJoueurs = joueurs.iterator();
    	
    	return iterateurJoueurs.next();
    }
    
    public boolean sabotEstVide() {
    	return sabot.estVide();
    }
    
    public void lancer() throws Exception {
    	nbTours = 0;
    	joueurAJoue = false;
    	iterateurJoueurs = joueurs.iterator();
    	remplirSabot(new JeuDeCartes());
    	distribuerCartes();
    	partie();
    }
    
    public void partie() {
    	nbTours++;
    	Joueur joueurActif = donnerJoueurSuivant();
    	
    	if (nbTours == 1 || ((joueurActif.donnerKmParcourus() < 1000) && (!sabotEstVide() || joueurAJoue))) {
    		joueurAJoue = jouerTour(joueurActif);
    		partie();
    	}
    		
    	else { // Fin de partie
    		List<Joueur> classement = classement();
    		System.out.println("\nFin de partie !");
    		System.out.println("Le classement des joueurs selon leur km parcouru est : " + classement.toString());
    		System.out.println("Le joueur " + classement.get(0) + " a gagné !");
    	}
    }
    
    public List<Joueur> classement() {
    	Comparator<Joueur> joueurComparator = new JoueurComparator();
    	Set<Joueur> classement = new TreeSet<>(joueurComparator);
    	
    	classement.addAll(joueurs);
    	
    	return new LinkedList<>(classement);
    }
}