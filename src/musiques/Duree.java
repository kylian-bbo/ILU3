package musiques;

public class Duree {
    private int minutes;
    private int secondes;

    protected Duree(int minutes, int secondes) {
        this.minutes = minutes;
        this.secondes = secondes;
    }

    public String toString() {
        String string = minutes + ":";
        if (secondes < 10)
            string += "0";
        return string + secondes;
    }
}
