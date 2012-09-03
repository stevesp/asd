package labs.lab20090907.tree;

public interface ABE {
	public boolean ABEVuoto();
	public Nodo radice();
	public Nodo sin(Nodo v);
	public Nodo des(Nodo v);
	public void aggiungiRadice(String e);
	public void innestaSin(Nodo u, ABE albero, String e);
	public void innestaDes(Nodo u, ABE albero, String e);
}