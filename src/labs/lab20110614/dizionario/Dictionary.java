package labs.lab20110614.dizionario;

public interface Dictionary<S> extends Iterable<S> {
	public void insert(S e, Comparable k);

	public void delete(Comparable k);

	public S search(Comparable k);
}
