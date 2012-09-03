package lists;

public interface Dizionario {
	public void insert(Object e, Comparable<Object> k);
	public void delete(Comparable<Object> k);
	public Object search(Comparable<Object> k);
}
