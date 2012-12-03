package stacks;

import commons.EccezioneStrutturaVuota;

public class PilaCollegata implements Pila {

	private Record top = null;

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
		return top == null;
	}

	@Override
	public void push(Object e) {
		Record p = new Record(e);
		p.next = top;
		top = p;
	}

	@Override
	public Object top() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");
		return top.elem;
	}

	@Override
	public void pop() {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");
		top = top.next;
	}

}
