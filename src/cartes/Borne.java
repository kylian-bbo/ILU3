package cartes;

public class Borne extends Carte {
	private int km;
	
	public Borne(int nombre, int km) {
		super(nombre);
		this.km = km;
	}

	protected int getKm() {
		return km;
	}

	public String toString() {
		return "Borne " + km;
	}
	
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			Borne b = (Borne) obj;
			return km == b.getKm();
		}
		return false;
	}
}