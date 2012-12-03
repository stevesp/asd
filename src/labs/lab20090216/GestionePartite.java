package labs.lab20090216;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import labs.lab20090216.lista.ListaOrdinata;
import labs.lab20090216.listawo.WOListLinked;
import labs.lab20090216.partita.Partita;

public class GestionePartite {
	static ListaOrdinata list;

	public static void main(String[] args) {
		list = new WOListLinked();

		inizializza();

		stampa();

		Calendar cal = Calendar.getInstance();
		cal.set(2011, 12, 31);
		int vinte = partiteVinteOspitante("Juventus", cal.getTime());
		System.out.println("La Juventus ha vinto " + vinte + " partite.");
	}

	public static void inizializza() {
		String[] squadre = new String[] { "Juventus", "Milan", "Lecce", "Bari" };
		Random golTeam1 = new Random();

		Random month = new Random();
		Random day = new Random();

		for (int i = 0; i < squadre.length; i++) {
			for (int j = 0; j < squadre.length; j++) {
				if (i == j)
					continue;

				int mese = month.nextInt(12);
				int giorno = day.nextInt(32) + 1;

				Calendar cal = Calendar.getInstance();
				cal.set(2011, mese, giorno);
				Date data = cal.getTime();

				int gol1 = golTeam1.nextInt(7);
				int gol2 = golTeam1.nextInt(7);

				list.insert(new Partita(data, squadre[i], squadre[j], gol1,
						gol2));
			}
		}
	}

	public static void stampa() {
		for (Object i : list)
			System.out.println(i);
	}

	public static int partiteVinteOspitante(String sqOspitante, Date d) {
		int count = 0;

		for (Object p : list) {
			if ((((Partita) p).getSqOspitante().equals(sqOspitante))
					&& ((Partita) p).getData().before(d)
					&& ((Partita) p).getRetiOspitante() > ((Partita) p)
							.getRetiOspitata())
				count++;
		}

		return count;
	}

}
