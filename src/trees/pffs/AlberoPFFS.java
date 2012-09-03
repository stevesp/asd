package trees.pffs;

import java.util.Iterator;

import exceptions.EccezioneNodoInvalido;

import trees.Albero;
import trees.AlberoVuotoException;
import trees.EccezioneNodoEsistente;
import trees.Nodo;
import trees.TreeIterator;

public class AlberoPFFS implements Albero, Iterable{
	private NodoPFFS radice = null;
	
	private boolean checkNode(Nodo v) {
		if (v == null)
			return true;
		if (((NodoPFFS) v).albero != this)
			return true;
		return false;
	}

	public Nodo padre(Nodo v) throws EccezioneNodoInvalido {
		if(checkNode(v))
			throw new EccezioneNodoInvalido();
		return ((NodoPFFS) v).padre;
	}

	public Nodo primoFiglio(Nodo v) throws EccezioneNodoInvalido {
		if(checkNode(v))
			throw new EccezioneNodoInvalido();
		return ((NodoPFFS) v).primo;
	}
	
	public Nodo succFratello(Nodo v) throws EccezioneNodoInvalido{
		if(checkNode(v)) 
			throw new EccezioneNodoInvalido();
		return ((NodoPFFS) v).succ;
	}

	public void insRadice(Object info)throws EccezioneNodoEsistente {
		if (radice != null) 
			throw new EccezioneNodoEsistente();
		radice = new NodoPFFS(info);
		radice.albero = this;
	}
		
	public void cancSottoAlbero(Nodo v) throws EccezioneNodoInvalido{
		if(checkNode(v)) throw new EccezioneNodoInvalido();
		if (v == radice) {
			radice = null;
			return;
		}
		NodoPFFS u = ((NodoPFFS) v).padre;
		if (u.primo == v) {
			u.primo = u.primo.succ;
		} else {
			NodoPFFS temp = u.primo;
			boolean nodoTrovato = false;
			for (; temp.succ != null; temp = temp.succ) {
				if (temp.succ == v) {
					nodoTrovato = true;
					break;
				}
			}
			if (nodoTrovato) temp.succ = temp.succ.succ;
		}
		((NodoPFFS) v).succ = null;
	}

	public void cambiaInfo(Nodo v, Object info) throws EccezioneNodoInvalido {
		if (checkNode(v)) throw new EccezioneNodoInvalido();
		((NodoPFFS) v).info = info;		
	}

	public Object info(Nodo v) throws EccezioneNodoInvalido {
		if (checkNode(v)) throw new EccezioneNodoInvalido();
		return ((NodoPFFS)v).info;
	}
	
	private void updateIdAlbero(Nodo u){
		((NodoPFFS)u).albero=this;		
		if (!foglia(u)) {
	       Nodo v=primoFiglio(u);
	       while (((NodoPFFS)v).succ!=null) {
	                updateIdAlbero(v);
	                v =succFratello(v);
	       }
	       updateIdAlbero(v);
		}
	}
	
	public void insprimoSottoAlbero(Nodo u, Albero a) {
		if (checkNode(u)) 
			throw new EccezioneNodoInvalido();
		if(a.alberoVuoto())
			throw new AlberoVuotoException("Albero che si sta innestando è vuoto");
			
		NodoPFFS z = (NodoPFFS) u;
		if (a.alberoVuoto()) return; //albero vuoto
		
		((NodoPFFS)a.radice()).succ=z.primo;
		z.primo=(NodoPFFS) a.radice();
		
		((NodoPFFS)a.radice()).padre = z;			
		((AlberoPFFS)a).radice = null;
		// modifico l'appartenenza dei nodi di a
		updateIdAlbero(z.primo); // modifico l'appartenenza dei nodi di a 
	}

	public Iterator iterator() {
		return new TreeIterator(this);
	}

	public boolean alberoVuoto() {
		//TODO
		return false;
	}
	
	public boolean fineFratelli(Nodo v) throws EccezioneNodoInvalido{
		//TODO
		return false;
	}
	
	public boolean foglia(Nodo v) throws EccezioneNodoInvalido{
		//TODO
		return false;
	}

	public Nodo radice() {
		//TODO
		return null;
	}
	
	public void insSottoAlbero(Nodo fratello, Albero a) {
		//TODO	
	}

}
