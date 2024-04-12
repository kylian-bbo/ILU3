package cartes;

public class Attaque extends Bataille {
	
	static {
		map.put(Type.FEU, "Feu rouge");
		map.put(Type.ESSENCE, "Panne d'essence");
		map.put(Type.CREVAISON, "Crevaison");
		map.put(Type.ACCIDENT, "Accident");
	}
	
	public Attaque(int nombre, Type type) {
		super(nombre, type);
	}
	
	public String toString() {
		return map.get(type);
	}
}