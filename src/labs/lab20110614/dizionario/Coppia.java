package labs.lab20110614.dizionario;

class Coppia<S> {
	S elem;
	Comparable chiave;

	Coppia(S e, Comparable k) {
		this.elem = e;
		this.chiave = k;
	}

	@Override
	public String toString() {
		return new String(this.elem + " " + this.chiave);
	}
}
