package cartes;

import java.util.Objects;

public class Botte extends Probleme {

	static {
		map.put(Type.FEU, "Vehicule prioritaire");
		map.put(Type.ESSENCE, "Citerne d'essence");
		map.put(Type.CREVAISON, "Increvable");
		map.put(Type.ACCIDENT, "As du volant");
	}
	
	public Botte(int nombre, Type type) {
		super(nombre, type);
	}
	
	public String toString() {
		return map.get(type);
	}

	//Pour pouvoir faire correctement le contains() sur le HashSet de la classe ZoneDeJeu :
	@Override
	public int hashCode() {
    	return Objects.hash(getType());
	}
}