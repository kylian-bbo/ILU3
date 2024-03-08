package cartes;

public abstract class Carte {
	private int nombre;
	
	protected Carte(int nombre) {
		this.nombre = nombre;
	}

	public int getNombre() {
		return nombre;
	}
	
	public boolean equals(Object obj) {
		return obj != null && obj.getClass() == getClass();
	}
}