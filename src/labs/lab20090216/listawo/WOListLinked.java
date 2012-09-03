package labs.lab20090216.listawo;

import java.util.Iterator;

import labs.lab20090216.lista.ListaOrdinata;

public class WOListLinked implements ListaOrdinata {

	private Puntatore inizioLista = null;
	private int size;
	
	public WOListLinked() {
		this.size = 0;
	}
	
	@Override
	public void insert(Comparable e) {
		Puntatore _new = new Puntatore(new Cella(e));
		
		if (this.isEmpty())
			inizioLista = _new;
		else {
			Puntatore tmp, q = inizioLista;

			for(tmp = inizioLista; tmp.link.successivo != null; tmp = tmp.link.successivo) {
				if (_new.link.elemento.compareTo(tmp.link.elemento) == 0)
					throw new EccezioneElementoPresente("Elemento già presente");
				
				if (_new.link.elemento.compareTo(tmp.link.elemento) < 0)
					break;
				
				q = tmp;
			}
			
			_new.link.successivo = tmp;
			if (inizioLista == q)
				inizioLista = _new;
			else
				q.link.successivo = _new;
		}
		
		size++;
	}

	private boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public int numElementi() {
		return this.size;
	}

	@Override
	public Iterator<Comparable> iterator() {
		return new WOListLinkedIterator(inizioLista);
	}

}
