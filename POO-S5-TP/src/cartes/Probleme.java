package cartes;

import java.util.HashMap;
import java.util.Map;

public abstract class Probleme extends Carte {
	protected Type type;
	protected static Map<Type, String> stringType = new HashMap<>();

	protected Probleme(Type t, int n) {
		super(n);
		this.type = t;
	}
	
	public String toString() {	
		switch (type) {
		case FEU:
			return stringType.get(Type.FEU);
		case ESSENCE:
			return stringType.get(Type.ESSENCE);
		case CREVAISON:
			return stringType.get(Type.CREVAISON);
		case ACCIDENT:
			return stringType.get(Type.ACCIDENT);
		default:
			return "";
		}
	}
	
	public Type getType() {
		return type;
	}
	
	public boolean equals(Probleme carte) {
		return this.type == carte.getType(); //super.equals
	}
}