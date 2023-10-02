package cartes;

import java.util.Objects;

public abstract class Carte {
	protected int nombre;
	
	protected Carte(int n) {
		this.nombre = n;
	}

	public int getNombre() {
		return nombre;
	}

}