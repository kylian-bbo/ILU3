package tri;

public enum Appreciation {
    UNE_ETOILE ("1 étoile"), DEUX_ETOILES ("2 étoiles"), TROIS_ETOILES ("3 étoiles"), QUATRE_ETOILES ("4 étoiles"), CINQ_ETOILES ("5 étoiles");

    private final String etoiles;

    Appreciation(String etoiles) {
        this.etoiles = etoiles;
    }

    public String toString() {
        return etoiles;
    }
}