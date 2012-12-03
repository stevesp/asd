package stacks;

import commons.EccezioneStrutturaVuota;

public class PilaArray implements Pila {

	private Object[] S = new Object[1];
	private int n = 0;

	@Override
	public boolean isEmpty() {
		return n == 0;
	}

	@Override
	public void push(Object e) {
		if (n == S.length) {
			Object[] temp = new Object[2 * S.length];
			for (int i = 0; i < n; i++)
				temp[i] = S[i];
			S = temp;
		}
		S[n] = e;
		n++;
	}

	@Override
	public Object top() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");

		return S[n - 1];
	}

	@Override
	public void pop() throws EccezioneStrutturaVuota {
		if (isEmpty())
			throw new EccezioneStrutturaVuota("Pila vuota");

		if (n <= S.length / 4) {
			Object[] temp = new Object[S.length / 2];
			for (int i = 0; i < n; i++)
				temp[i] = S[i];
			S = temp;
		}
		n--;
	}
}