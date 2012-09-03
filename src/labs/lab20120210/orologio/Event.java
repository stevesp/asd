package labs.lab20120210.orologio;

public class Event {
	
	private String evento;
	
	public Event(String string) {
		this.evento = string;
	}

	@Override
	public String toString() {
		return evento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		return true;
	}
	

}
