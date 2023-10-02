package cartes;

public abstract class Carte {
	protected int nombre;
	
	protected Carte(int n) {
		this.nombre = n;
	}

	public int getNombre() {
		return nombre;
	}
	
	public boolean equals(Carte carte) {
		return this.getClass() == carte.getClass(); // !null
	}
}