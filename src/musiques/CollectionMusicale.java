package musiques;

import java.util.HashSet;
import java.util.Set;

public class CollectionMusicale {
    private Set<Album> albums;
    private int nbAlbums;

    public CollectionMusicale() {
        this.albums = new HashSet<>();
        this.nbAlbums = 0;
    }

    public void ajouterAlbum(Album album) { 
        albums.add(album);
        nbAlbums++;
    }

    public void ajouterAlbums(Album... albums) {
        for (Album album : albums)
            ajouterAlbum(album);
    }

    public String toString() {
        String string = "Collection musicale (" + nbAlbums + " album";
        if (nbAlbums == 0 || nbAlbums > 1)
            string += 's';
        string += ") :";

        for (Album album : albums)
            string += "\n" + album.toString().replace("\n", "\n\t");
        
        return string;
    }
}
