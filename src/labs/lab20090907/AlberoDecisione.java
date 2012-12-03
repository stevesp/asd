package labs.lab20090907;

import labs.lab20090907.tree.ABE;
import labs.lab20090907.treepf.ABEPF;
import labs.lab20090907.treepf.NodoPF;

public class AlberoDecisione {

	private static String[][] tabella = {
			{ "soleggiato", "alta", "elevata", "debole", "no" },
			{ "soleggiato", "bassa", "normale", "debole", "si" },
			{ "coperto", "bassa", "elevata", "debole", "si" },
			{ "coperto", "bassa", "elevata", "forte", "no" } };

	public static String classifica(ABE alberoDecisione, int i) {
		NodoPF current = (NodoPF) alberoDecisione.radice();

		for (int j = 0; j < tabella[i].length; j++) {
			if (current.etichettaRamoSin().equals(tabella[i][j])) {
				current = (NodoPF) alberoDecisione.sin(current);
			} else if (current.etichettaRamoDes().equals(tabella[i][j])) {
				current = (NodoPF) alberoDecisione.des(current);
			} else
				j++;

			if ((current.etichettaNodo().equals("si"))
					|| current.etichettaNodo().equals("no"))
				break;
		}

		return current.etichettaNodo();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ABE albero = new ABEPF();
		albero.aggiungiRadice("Tempo");

		ABE temp = new ABEPF();
		temp.aggiungiRadice("Temperatura");

		ABE noT = new ABEPF();
		noT.aggiungiRadice("no");

		ABE siT = new ABEPF();
		siT.aggiungiRadice("si");

		temp.innestaDes(temp.radice(), siT, "bassa");
		temp.innestaSin(temp.radice(), noT, "alta");

		ABE vento = new ABEPF();
		vento.aggiungiRadice("Vento");

		ABE noV = new ABEPF();
		noV.aggiungiRadice("no");

		ABE siV = new ABEPF();
		siV.aggiungiRadice("si");

		vento.innestaDes(vento.radice(), noV, "forte");
		vento.innestaSin(vento.radice(), siV, "debole");

		albero.innestaDes(albero.radice(), vento, "coperto");
		albero.innestaSin(albero.radice(), temp, "soleggiato");

		for (int i = 0; i < tabella.length; i++)
			System.out
					.println("Riga " + (i + 1) + ": " + classifica(albero, i));
	}
}
