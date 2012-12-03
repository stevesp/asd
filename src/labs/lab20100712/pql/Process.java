package labs.lab20100712.pql;

import labs.lab20100712.pq.EccezionePrioritaNonValida;
import labs.lab20100712.pq.Priority;

public class Process {

	public final int UNRUNNABLE = 0;
	public final int RUNNABLE = 1;
	public final int STOPPED = 2;

	private String path;
	private int id, state;
	private Priority priority;

	private static int idCount = 0;

	public Process(String path, int priority) {

		try {
			this.priority = new Priority(priority);
		} catch (EccezionePrioritaNonValida e) {
			System.out.println(e);
		}

		this.path = path;
		this.id = this.idCount++;
		this.state = UNRUNNABLE;
	}

	public int getID() {
		return this.id;
	}

	public void setState(int state) {
		switch (state) {
		case 0:
			if (this.state != RUNNABLE)
				throw new EccezioneStatoNonValido();

			this.state = UNRUNNABLE;
			break;
		case 1:
			this.state = RUNNABLE;
			break;
		case 2:
			if (this.state != RUNNABLE)
				throw new EccezioneStatoNonValido();
			this.state = STOPPED;
			break;
		default:
			break;
		}
	}

	public String getPath() {
		return this.path;
	}

	public int getPriority() {
		return priority.getPriority();
	}

	public void setPriority(int priority) {
		try {
			this.priority = new Priority(priority);
		} catch (EccezionePrioritaNonValida e) {
			System.out.println(e);
		}
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		str.append("[ ");
		str.append(id + " |");
		str.append(" priorità: " + this.priority);
		str.append(" path: " + this.path);
		str.append(" stato: " + this.state);
		str.append(" ]");

		return str.toString();
	}

}
