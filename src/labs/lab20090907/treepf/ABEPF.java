package labs.lab20090907.treepf;

import labs.lab20090907.tree.ABE;
import labs.lab20090907.tree.Nodo;

public class ABEPF implements ABE {
	
	private NodoPF radice = null;

	@Override
	public boolean ABEVuoto() {
		return radice == null;
	}

	@Override
	public Nodo radice() {
		return radice;
	}

	@Override
	public Nodo sin(Nodo v) {
		return ((NodoPF) v).sin;
	}

	@Override
	public Nodo des(Nodo v) {
		return ((NodoPF) v).des;
	}

	@Override
	public void aggiungiRadice(String e) {
		if (radice != null) throw new EccezioneNodoEsistente("Radice esistente");
		
		radice = new NodoPF(e);
		radice.albero = this;
	}

	@Override
	public void innestaSin(Nodo u, ABE albero, String e) {
		if (((NodoPF) u).sin != null)
			throw new EccezioneNodoEsistente("Nodo sinistro esistente");
		
		((NodoPF) u).eSin = e;
		((NodoPF) u).sin = (NodoPF) albero.radice();
		((NodoPF) u).sin.padre = (NodoPF) u;
		((NodoPF) u).sin.albero = this;
		
		albero = null;
	}

	@Override
	public void innestaDes(Nodo u, ABE albero, String e) {
		if (((NodoPF) u).des != null)
			throw new EccezioneNodoEsistente("Nodo destro esistente");
		
		((NodoPF) u).eDes = e;
		((NodoPF) u).des = (NodoPF) albero.radice();
		((NodoPF) u).des.padre = (NodoPF) u;
		((NodoPF) u).des.albero = this;
		
		albero = null;		
	}

}
