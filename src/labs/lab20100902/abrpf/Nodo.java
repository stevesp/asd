package labs.lab20100902.abrpf;

public class Nodo {

	Comparable valore;
	Nodo sin, des;

	public Nodo(Comparable valore) {
		this.valore = valore;
		this.sin = this.des = null;
	}

}
