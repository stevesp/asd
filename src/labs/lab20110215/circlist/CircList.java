package lab20110215.circlist;

public interface CircList<T> extends Iterable<T>{
	public void addCircList(T object);
	public void delCircList();
	public T value();
	public boolean isEmpty();
	public int numItem();
	public void setDir(Direction d);
	public void ruota();
}
