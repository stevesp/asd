package lists.cursorlist;

import lists.Posizione;

public class Cursore implements Posizione {

	public int cursore;

	public Cursore(int cursore) {
		this.cursore = cursore;
	}

	public String toString() {
		return new Integer(cursore).toString();
	}
}
