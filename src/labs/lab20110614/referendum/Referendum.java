package labs.lab20110614.referendum;

import labs.lab20110614.dizionario.ArrayOrdinato;
import labs.lab20110614.dizionario.Dictionary;

public class Referendum {
	protected Dictionary<Quesito<Voto>> referendum;
	
	private int votanti;
	
	public Referendum(int votanti){
		this.votanti = votanti;
		this.referendum = new ArrayOrdinato<Quesito<Voto>>();
	}
	
	public void aggiungiQuesito(Quesito<Voto> q){
		this.referendum.insert(q, q.quesito);
	}
	
	public void scrutinaVoto(Quesito<Voto> q, Voto v){
		Quesito<Voto> tmp = referendum.search(q.quesito);

		if (tmp == null)
			throw new QuesitoNonEsistente();
		
		tmp.add(v);
	}
	
	public int numVoti(Quesito<Voto> q){
		Quesito<Voto> tmp = referendum.search(q.quesito);

		if (tmp == null)
			throw new QuesitoNonEsistente();
		
		return tmp.numberElements();
	}
	
	public Voto voto(Quesito<Voto> q, int i){
		Quesito<Voto> tmp = referendum.search(q.quesito);

		if (tmp == null)
			throw new QuesitoNonEsistente();

		return tmp.getElement(i);
	}
	
	public boolean quorum(Quesito<Voto> q){
		Quesito<Voto> tmp = referendum.search(q.quesito);

		if (tmp == null)
			throw new QuesitoNonEsistente();

		return (tmp.numberElements() >= this.votanti/2);
	}
}
