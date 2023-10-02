package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int km, int n) {
		super(n);
		this.km = km;
	}
	
	public String toString() {
		return "Borne - " + km;
	}

	public int getKm() {
		return km;
	}
	
	public boolean equals(Borne carte) {
		return this.km == carte.getKm();
	}
}