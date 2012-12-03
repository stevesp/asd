package labs.lab20090216.partita;

import java.util.Calendar;
import java.util.Date;

public class Partita implements Comparable<Partita> {

	private Date data;
	private String sqOspitante, sqOspitata;
	private int retiOspitante, retiOspitata;

	public Partita(Date data, String sqOspitante, String sqOspitata,
			int retiOspitante, int retiOspitata) {
		this.data = data;
		this.sqOspitante = sqOspitante;
		this.sqOspitata = sqOspitata;
		this.retiOspitante = retiOspitante;
		this.retiOspitata = retiOspitata;
	}

	public Date getData() {
		return data;
	}

	public String getSqOspitante() {
		return sqOspitante;
	}

	public String getSqOspitata() {
		return sqOspitata;
	}

	public int getRetiOspitante() {
		return retiOspitante;
	}

	public int getRetiOspitata() {
		return retiOspitata;
	}

	@Override
	public String toString() {

		StringBuffer buffer = new StringBuffer();

		buffer.append("Partita [ ");

		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		buffer.append(cal.getTime() + ", ");

		buffer.append(sqOspitante + " - " + sqOspitata + " ");
		buffer.append(retiOspitante + " - " + retiOspitata);

		buffer.append(" ]");

		return buffer.toString();
	}

	@Override
	public int compareTo(Partita partita) {
		if (this.data.compareTo(partita.data) == 0)
			return this.sqOspitante.compareTo(partita.sqOspitante);

		return (this.data.compareTo(partita.data));
	}
}
