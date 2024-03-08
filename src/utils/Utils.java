package utils;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Utils {

	public static <E> E extraire(List<E> liste) { // A tester
		int i = (int)(Math.random() * liste.size());
	
		return liste.remove(i);
	}
	
	public static <E> E extraireIterateur(List<E> liste) { // A tester
		int i = (int)(Math.random() * liste.size());
		Iterator<E> ite = liste.iterator();
		E elem = null;
		
		for (int j = 0; j < i; j++)
			elem = ite.next();
		ite.remove();
		
		return elem;
	}
	
	public static <E> List<E> melanger(List<E> liste) {
		List<E> listeMelangee = new LinkedList<>();
		
		while (liste.size() > 0)
			listeMelangee.add(extraire(liste));
			
		return listeMelangee;
	}
	
	public static <E> boolean verifierMelange(List<E> l1, List<E> l2) {
		Iterator<E> ite = l1.iterator();
		E elem;
		boolean result = true;
		
		for (int i = 0; i < l1.size() && result; i++) {
			elem = ite.next();
			result = Collections.frequency(l1, elem) == Collections.frequency(l2, elem);
		}
		
		return result;
	}
	
	// A finir ( 4) )
}
