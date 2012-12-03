package labs.lab20090907.treepf;

import labs.lab20090907.tree.ABE;
import labs.lab20090907.tree.Nodo;

public class NodoPF implements Nodo {

	NodoPF sin, des, padre;
	ABE albero;
	String eSin, eDes;
	private String e;

	public NodoPF(String e) {
		this.e = e;
		sin = des = null;
	}

	@Override
	public String etichettaNodo() {
		return e;
	}

	@Override
	public String etichettaRamoSin() {
		return eSin;
	}

	@Override
	public String etichettaRamoDes() {
		return eDes;
	}

}
