package lab20120117.list;

public interface AddOnlyList<S> extends Iterable<S>{
	public void add(S e);
	public void forward();
	public void backward();	
}
