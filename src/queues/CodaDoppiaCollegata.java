package queues;

import exceptions.EccezioneStrutturaVuota;

public class CodaDoppiaCollegata implements CodaDoppia {

	private Record inizio = null;
	private Record fine = null;
	
	private class Record {
 		public Object elem;
 		public Record next; 

 		public Record(Object e) {
			this.elem = e;
			this.next = null;
		}
	}
	
	@Override
	public boolean isEmpty() {
		return this.inizio == null;
	}

	@Override
	public void enqueue(Object e) {
		if (this.isEmpty())
			this.inizio = this.fine = new Record(e);
		else {
			this.fine.next = new Record(e);
			this.fine = this.fine.next;
		}		
	}

	@Override
	public Object first() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		
		return this.inizio.elem;
	}

	@Override
	public void dequeue() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		
		Record tmp = this.inizio;
		while (tmp.next != this.fine)
			tmp = tmp.next;
	
		this.fine = tmp;
	}

	@Override
	public void push(Object e) {
		if (isEmpty())
			this.inizio = this.fine = new Record(e);
		else {
			Record tmp = this.inizio;
			this.inizio = new Record(e);
			this.inizio.next = tmp;
		}
	}

	@Override
	public Object top() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		return this.fine.elem;
	}

	@Override
	public void pop() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Coda vuota");
		
		this.inizio = this.inizio.next;
	}

}
