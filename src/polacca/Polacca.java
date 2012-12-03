package polacca;

import stacks.Pila;
import stacks.PilaCollegata;

import commons.EccezioneStrutturaVuota;

public class Polacca {

	private static boolean operatore(String elemento) {
		return (elemento.equals("+") || elemento.equals("-")
				|| elemento.equals("/") || elemento.equals("*"));
	}

	public static int valuta(String espressione) {
		String[] elementi = espressione.split(" ");
		Pila pila = new PilaCollegata();
		int operando, operando1, operando2;

		for (int i = 0; i < elementi.length; i++) {
			if (elementi[i].equals(""))
				continue;

			if (!operatore(elementi[i])) {
				try {
					operando = Integer.parseInt(elementi[i]);
				} catch (NumberFormatException e) {
					throw new EccezioneEspressioneNonValida(elementi[i]
							+ ": nè operatore nè operando");
				}
				pila.push(operando);
			} else {
				try {
					operando2 = (Integer) pila.top();
					pila.pop();
					operando1 = (Integer) pila.top();
					pila.pop();
				} catch (EccezioneStrutturaVuota e) {
					throw new EccezioneEspressioneNonValida("operando mancante");
				}

				if (elementi[i].equals("+"))
					pila.push(operando1 + operando2);
				else if (elementi[i].equals("-"))
					pila.push(operando1 - operando2);
				else if (elementi[i].equals("/"))
					pila.push(operando1 / operando2);
				else if (elementi[i].equals("*"))
					pila.push(operando1 * operando2);
			}
		}

		int risultato = ((Integer) pila.top()).intValue();
		pila.pop();

		if (!pila.isEmpty())
			throw new EccezioneEspressioneNonValida("operatore mancante");

		return risultato;
	}
}
