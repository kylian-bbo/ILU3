package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int km, int n) {
		super(n);
		this.km = km;
	}
}
