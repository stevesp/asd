package objects;

public class Persona implements Comparable<Object> {

	public Persona(String name) {
		this.name = name;
	}

	public Persona() {
		this.name = null;
	}

	@Override
	public int compareTo(Object o) {
		if (((Persona) o).getName().compareTo(this.name) < 0)
			return +1;
		else if (((Persona) o).getName().compareTo(this.name) > 0)
			return -1;
		return 0;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return this.name;
	}

	private String name;

}
