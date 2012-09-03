package lab20100902.abr;

public interface ABR extends Iterable {
	public boolean nuovoABR();
	public ABR sinistroABR();
	public Comparable radiceABR();
	public ABR destroABR();
	public void inserisciABR(Comparable valore);
}
