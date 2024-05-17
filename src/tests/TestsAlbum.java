package tests;

import musiques.Album;
import musiques.Musique;

public class TestsAlbum {
    public static void main(String[] args) {
        Musique m1 = new Musique("Brave New World", 5, 4, 1);
        Musique m2 = new Musique("Into the Storm", 8, 4, 34);

        Album a1 = new Album("Frostpunk Original Soundtrack", "Piotr Musiał", 2018, m1, m2);

        System.out.println("\nTest d'affichage d'un album :\n");
        System.out.println(a1);
    }
}