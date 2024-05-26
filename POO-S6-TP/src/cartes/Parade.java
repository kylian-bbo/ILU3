package cartes;

public class Parade extends Bataille {
	
	static {
		map.put(Type.FEU, "Feu vert");
		map.put(Type.ESSENCE, "Essence");
		map.put(Type.CREVAISON, "Roue de secours");
		map.put(Type.ACCIDENT, "Reparations");
	}
	
	public Parade(int nombre, Type type) {
		super(nombre, type);
	}
	
	public String toString() {
		return map.get(type);
	}
}