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
	
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			Probleme p = (Probleme) obj;
			return type.equals(p.type);
		}
		return false;
	}
}