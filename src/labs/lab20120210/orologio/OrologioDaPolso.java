package labs.lab20120210.orologio;

import labs.lab20120210.frazioni.Minuto;
import labs.lab20120210.frazioni.Ora;

public class OrologioDaPolso {

	private Orologio<Ora> ore;
	private Orologio<Minuto> minuti;

	public OrologioDaPolso() {
		ore = new Orologio<Ora>();
		minuti = new Orologio<Minuto>();

		for (Integer i = 23; i >= 0; i--)
			ore.add(new Ora(i.toString(), null));

		for (Integer i = 59; i >= 0; i--) {
			if (i.compareTo(new Integer(0)) == 0)
				minuti.add(new Minuto(0 + i.toString(), new Event("Bip Bip")));
			else if (i.compareTo(new Integer(10)) < 0)
				minuti.add(new Minuto(0 + i.toString(), null));
			else if (i.compareTo(new Integer(30)) == 0)
				minuti.add(new Minuto(i.toString(), new Event("Bip")));
			else
				minuti.add(new Minuto(i.toString(), null));
		}

		for (Ora o : ore) {
			for (Minuto m : minuti)
				System.out.println(o + ":" + m);
		}
	}

	public void start() {
		Ora oStart = ore.value();
		Minuto mStart = minuti.value();

		Ora o = ore.value();
		minuti.rotateF();
		Minuto m = minuti.value();

		while ((oStart != o) || (mStart != m)) {
			if ((o.getEvent() != null) && (m.equals(mStart)))
				System.out.println(o.toString());

			if (m.getEvent() != null)
				System.out.println(o.getName() + ":" + m.getName() + " "
						+ m.getEvent());

			minuti.rotateF();
			m = minuti.value();

			if (m.equals(mStart)) {
				ore.rotateF();
				o = ore.value();
			}
		}

		if (mStart.getEvent() != null)
			System.out.println(oStart.getName() + ":" + mStart.getName() + " "
					+ mStart.getEvent());
	}

	public boolean equals(OrologioDaPolso orologio) {
		return (this.ore.equals(orologio.ore) && this.minuti
				.equals(orologio.minuti));
	}
}
