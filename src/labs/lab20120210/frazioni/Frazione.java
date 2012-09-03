package lab20120210.frazioni;

import lab20120210.orologio.Event;

public abstract class Frazione {

	private String nome;
	private Event evento;
	
	public Frazione(String nome, Event evento) {
		this.nome = nome;
		this.evento = evento;
	}
	
	public String getName(){
		return this.nome;
	}
	
	public Event getEvent(){
		return this.evento;
	}
	
	public void setEvent(Event evento){
		this.evento = evento;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frazione other = (Frazione) obj;
		if (evento == null) {
			if (other.evento != null)
				return false;
		} else if (!evento.equals(other.evento))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
}
