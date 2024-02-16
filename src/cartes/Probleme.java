package cartes;

public abstract class Probleme extends Carte {
	private Type type;
	
	protected Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}
	
	protected Type getType() {
		return type;
	}
}