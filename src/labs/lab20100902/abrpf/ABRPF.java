package lab20100902.abrpf;

import java.util.Iterator;

import lab20100902.abr.ABR;

public class ABRPF implements ABR {

	private Nodo radice;
	
	@Override
	public boolean nuovoABR() {
		return radice == null;
	}

	@Override
	public ABR sinistroABR() {
		if (radice.sin == null)
			throw new EccesioneNessunNodo("Non c'è alcun nodo sinistro");
		
		ABRPF sinistro = new ABRPF();
		
		sinistro.radice = radice.sin;
		
		return sinistro;
	}

	@Override
	public Comparable radiceABR() {
		if (nuovoABR())
			throw new EccezioneRadiceNonValida();
		
		return radice.valore;
	}

	@Override
	public ABR destroABR() {
		if (radice.des == null)
			throw new EccesioneNessunNodo("Non c'è alcun nodo destro");
		
		ABRPF destro = new ABRPF();
		
		destro.radice = radice.des;
		
		return destro;
	}

	@Override
	public void inserisciABR(Comparable valore) {
		Nodo _new = new Nodo(valore);
		
		if (nuovoABR())
			radice = _new;
		else {
			Nodo nodo = radice;
			Nodo padre = radice;
			
			while(true){
				padre = nodo;
				
				if(_new.valore.compareTo(nodo.valore) <= 0){
					if (nodo.sin == null){
						padre.sin = _new;
						break;
					}
					nodo = nodo.sin;
				} else {
					if (nodo.des == null){
						padre.des = _new;
						break;
					}
					nodo = nodo.des;
				}
			}
		}
	}

	@Override
	public Iterator iterator() {
		return new ABRPFIterator(radice);
	}
}
