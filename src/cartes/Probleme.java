package cartes;

import java.util.HashMap;
import java.util.Map;

public abstract class Probleme extends Carte {
	
	protected Type type;
	static final Map<Type,String> map = new HashMap<>();
	
	protected Probleme(int nombre, Type type) {
		super(nombre);
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) {
			Probleme p = (Probleme) obj;
			return type.equals(p.type);
		}
		return false;
	}
}