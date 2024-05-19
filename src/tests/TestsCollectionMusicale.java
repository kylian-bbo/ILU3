package tests;

import musiques.Album;
import musiques.CollectionMusicale;
import musiques.Musique;

public class TestsCollectionMusicale {
    public static void main(String[] args) {
        Album a1 = new Album("Test1", "Artiste1", 2018);
        a1.ajouterMusiques(
                new Musique("Test1Musique1", 1, 4, 1),
                new Musique("Test1Musique2", 2, 4, 34),
                new Musique("Test1Musique3", 3, 1, 20),
                new Musique("Test1Musique4", 4, 0, 45)
                );
        
        Album a2 = new Album("Test2", "Artiste2", 2019);
        a2.ajouterMusiques(
                new Musique("Test2Musique1", 5, 1, 1),
                new Musique("Test2Musique2", 10, 2, 26)
                );

        CollectionMusicale c = new CollectionMusicale();
        c.ajouterAlbums(a1, a2);

        System.out.println("\nTest d'affichage de la collection :\n");
        System.out.println(c);
    }
}