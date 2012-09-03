package labs.lab20090615.lista;

public class WODoubleLinkedList implements AOLista {

	private Elemento listHead = new Elemento(null);
	
	private class Elemento implements Posizione{
		Object dato;
		Elemento successivo;
		Elemento precedente;
		
		Elemento(Object e){
			this.dato = e;
			this.successivo = this.precedente = null;
		}
	}
	
	@Override
	public Posizione firstList() {
		return listHead;
	}

	@Override
	public void insert(Object e, Posizione p) {
		//TODO
		//controllare che p sia una posizione valida
		
		Elemento q = new Elemento(e);
		
		if(listHead.successivo == null) {
			listHead.successivo = listHead.precedente = q;
			q.successivo = q.precedente = listHead;
		} else {
			q.successivo = (Elemento) succ(p);
			q.precedente = (Elemento) p;
			((Elemento) succ(p)).precedente = q;
			((Elemento) p).successivo = q;
		}
	}

	@Override
	public Posizione succ(Posizione p) {
		if (listHead.successivo == null)
			throw new EccezioneListaVuota("Lista vuota");
		
		if (endList(p))
			return listHead;
		else if (p == firstList())
			return listHead.successivo;
		else
			return ((Elemento) p).successivo;
	}

	@Override
	public Posizione pred(Posizione p) {
		if (listHead.successivo == null)
			throw new EccezioneListaVuota("Lista vuota");
		
		if(p == firstList())
			return listHead.precedente;
		else
			return ((Elemento) p).precedente;
	}

	@Override
	public boolean endList(Posizione p) {
		if (listHead.successivo == null)
			throw new EccezioneListaVuota("Lista vuota");
		
		return ((Elemento) p).successivo == listHead;
	}

	@Override
	public Object readList(Posizione p) throws EccezioneListaVuota {
		if (listHead.successivo == null)
			throw new EccezioneListaVuota("Lista vuota");
		
		return ((Elemento) p).successivo.dato;
	}

}
