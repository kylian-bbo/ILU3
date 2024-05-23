package main;

import java.util.ArrayList;
import java.util.List;

import musiques.Album;
import musiques.CollectionMusicale;
import musiques.Musique;

public class GenerationCollectionMusicale {
    protected static Album[] genererAlbums() {
            List<Album> listAlbum = new ArrayList<>();

            Album a1 = new Album("Test1", "Artiste1", 2018);
            a1.ajouterMusiques(
                    new Musique("Test1Musique1", 1, 4, 1),
                    new Musique("Test1Musique2", 2, 4, 34),
                    new Musique("Test1Musique3", 3, 1, 20),
                    new Musique("Test1Musique4", 4, 0, 45)
                    );
            listAlbum.add(a1);
            
            Album a2 = new Album("Test2", "Artiste2", 2019);
            a2.ajouterMusiques(
                    new Musique("Test2Musique5", 5, 1, 1),
                    new Musique("Test2Musique10", 10, 2, 26)
                    );
            listAlbum.add(a2);
            
            return listAlbum.toArray(new Album[0]);
        }

        protected static CollectionMusicale genererCollectionMusicale() {
            CollectionMusicale collectionMusicale = new CollectionMusicale();
            collectionMusicale.ajouterAlbums(genererAlbums());
            return collectionMusicale;
    }
}