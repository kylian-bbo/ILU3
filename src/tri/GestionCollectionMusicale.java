package tri;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

import musiques.CollectionMusicale;
import musiques.Musique;
import musiques.Album;

public class GestionCollectionMusicale {
    private static final String JAUNE = "\033[33m";
    private static final String FIN_JAUNE = "\033[0m";

    private CollectionMusicale collectionMusicale;
    private Map<Appreciation, List<Musique>> mapMusiques;

    public GestionCollectionMusicale(CollectionMusicale collectionMusicale) {
        this.collectionMusicale = collectionMusicale;
        this.mapMusiques = new TreeMap<>();
    }

    public void afficherCollectionMusicale() {
        System.out.println(collectionMusicale.toString());
    }

    public void afficherMapMusique() {
        for (Appreciation appreciation : mapMusiques.keySet()) {
            System.out.println("~ " + JAUNE + appreciation + FIN_JAUNE + " :");
            for (Musique musique : mapMusiques.get(appreciation))
                System.out.println("\t" + musique);
            
        }
    }

    public Musique[] genererListeMusiques(int choix) {
        Musique[] listeMusiques = collectionMusicale.getMusiques();
        
        switch (choix) {
            case 1:
                //Rien à faire, déjà dans l'ordre d'ajout.
                break;
            case 2:
                //TODO: Lien Ocaml -> Par titre

                break;
            case 3:
                //TODO: Lien Ocaml -> Par Artiste

                break;
            case 4:
                //TODO: Lien Ocaml -> Par Durée

                break;
            default:
                System.out.println("Erreur : Problème menuTriSwitch, retour au menu principal.");
                break;
        }
        
        return listeMusiques;
    }

    //Return true si la musique à bien été ajoutée
    public boolean ajouterMusiqueNotee(Musique musique, int choix) {
        Appreciation appreciation;

        switch (choix) {
            case 1:
                appreciation = Appreciation.UNE_ETOILE;
                break;
            case 2:
                appreciation = Appreciation.DEUX_ETOILES;
                break;
            case 3:
                appreciation = Appreciation.TROIS_ETOILES;
                break;
            case 4:
                appreciation = Appreciation.QUATRE_ETOILES;
                break;
            case 5:
                appreciation = Appreciation.CINQ_ETOILES;
                break;
            default:
                return false;
        }
        
        if (!mapMusiques.containsKey(appreciation))
            mapMusiques.put(appreciation, new ArrayList<>());
        mapMusiques.get(appreciation).add(musique);

        return true;
    }

    private void supprimerMusiquesCollectionMusicale(List<Musique> musiquesASupprimer) {
        for (Album album : collectionMusicale)
            album.supprimerMusique(musiquesASupprimer);
    }

    //Return true si les musiques ont bien été supprimées
    public void supprimerMusiquesNoteInfX(int x) {
        List<Musique> musiquesASupprimer = new ArrayList<>();

        switch (x) {
            case 5:
                musiquesASupprimer.addAll(mapMusiques.get(Appreciation.QUATRE_ETOILES));
                mapMusiques.remove(Appreciation.QUATRE_ETOILES);
            case 4:
                musiquesASupprimer.addAll(mapMusiques.get(Appreciation.TROIS_ETOILES));
                mapMusiques.remove(Appreciation.TROIS_ETOILES);
            case 3:
                musiquesASupprimer.addAll(mapMusiques.get(Appreciation.DEUX_ETOILES));
                mapMusiques.remove(Appreciation.DEUX_ETOILES);
            case 2:
                musiquesASupprimer.addAll(mapMusiques.get(Appreciation.UNE_ETOILE));
                mapMusiques.remove(Appreciation.UNE_ETOILE);
                break;
            default:
                return;
        }
        
        supprimerMusiquesCollectionMusicale(musiquesASupprimer);
    }
}