package musiques;

public class Musique {
	private Album album;
	private String nom;
	private int numPiste;
	private Duree duree;
	
	public Musique(String nom, int numPiste, int minutes, int secondes) {
		this.album = null;
		this.nom = nom;
		this.numPiste = numPiste;
		this.duree = new Duree(minutes, secondes);
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public String getNom() {
		return nom;
	}

	public int getNumPiste() {
		return numPiste;
	}

	public String getDuree() {
		return duree.toString();
	}

	public String toString() {
		return numPiste + " - " + nom + ", " + duree.toString();
	}
}
