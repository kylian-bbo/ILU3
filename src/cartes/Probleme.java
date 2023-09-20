package cartes;

public abstract class Probleme extends Carte {
	protected Type type;
	
	protected Probleme(Type t, int n) {
		super(n);
		this.type = t;
	}
}
