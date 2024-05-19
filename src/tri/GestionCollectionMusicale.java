package tri;

import musiques.CollectionMusicale;

public class GestionCollectionMusicale {
    private CollectionMusicale collectionMusicale;

    public GestionCollectionMusicale(CollectionMusicale collectionMusicale) {
        this.collectionMusicale = collectionMusicale;
    }

    public void afficherCollectionMusicale() {
        System.out.println(collectionMusicale.toString());
    }
}
