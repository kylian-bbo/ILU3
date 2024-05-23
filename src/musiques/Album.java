package musiques;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Album implements Iterable<Musique> {
	private String nom;
	private String artiste;
	private int annee;
	private List<Musique> musiques;
	
	public Album(String nom, String artiste, int annee) {
		this.nom = nom;
		this.artiste = artiste;
		this.annee = annee;
		this.musiques = new ArrayList<>();
	}

	public String getNom() {
		return nom;
	}

	public String getArtiste() {
		return artiste;
	}

	public int getAnnee() {
		return annee;
	}

	public void ajouterMusique(Musique musique) {
		musique.setAlbum(this);
		musiques.add(musique);
	}
	
	public void ajouterMusiques(Musique... musiques) {
		for (Musique musique : musiques)
			ajouterMusique(musique);
	}

	public void supprimerMusique(List<Musique> musiquesASupprimer) {
		musiques.removeAll(musiquesASupprimer);
	}

	public String toString() {
		String string = "\t~ Nom : " + nom + ", Artiste : " + artiste + ", Année : " + annee + '\n';

		for (Musique musique : musiques)
			string += "\t" + musique.toString() + '\n';
	
		return string;
	}

	@Override
	public Iterator<Musique> iterator() {
		return musiques.iterator();
	}

	@Override
	public int hashCode() {
		return 31 * (nom.hashCode() + artiste.hashCode() + annee);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj.getClass() == getClass()) {
			Album alb = (Album) obj;
			return nom.equals(alb.getNom()) && artiste.equals(alb.getArtiste()) && annee == alb.getAnnee();
		}
		return false;
	}
}