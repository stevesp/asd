package lab20100916.pilacollegata;

class Cella<T> {

	T elem;
	Puntatore successivo;
	
	Cella(T e) {
		this.elem = e;
		this.successivo = null;
	}
	
}
