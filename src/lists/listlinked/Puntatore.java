package lists.listlinked;

import lists.Posizione;

class Puntatore implements Posizione {

	public Cella link;

	public Puntatore(Cella c) {
		link = c;
	}
}
