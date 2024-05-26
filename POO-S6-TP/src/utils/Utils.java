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
		
		while (!liste.isEmpty())
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
	
	public static <E> List<E> rassembler(List<E> liste) {
		List<E> listeRassemblee = new LinkedList<>();
		Iterator<E> ite;
		E e1;
		E e2;
		
		while (!liste.isEmpty()) {
			ite = liste.iterator();
			e1 = ite.next();
			ite.remove();
			listeRassemblee.add(e1);
			
			while (ite.hasNext()) {
				e2 = ite.next();
				if (e2.equals(e1)) {
					listeRassemblee.add(e2);
					ite.remove();
				}
			}
		}
		
		return listeRassemblee;
	}
	
	public static <E> boolean verifierRassemblement(List<E> liste) {
		boolean result = true;
		Iterator<E> ite = liste.iterator();
		E e1;
		int i;
		
		E e2 = ite.next();
		while (ite.hasNext() && result) {
			e1 = e2;
			i = 1;
			
			while (ite.hasNext() && (e2 = ite.next()).equals(e1))
				i++;
			if (Collections.frequency(liste, e1) != i)
				result = false;
		}
		
		return result;
	}
}
